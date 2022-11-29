DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS empresa CASCADE;
DROP TABLE IF EXISTS producto CASCADE;
DROP TABLE IF EXISTS transaccion CASCADE;
DROP TABLE IF EXISTS carrito CASCADE;
DROP TABLE IF EXISTS metodocompra CASCADE;
DROP TABLE IF EXISTS valoracion CASCADE;
DROP TABLE IF EXISTS carroproducto CASCADE;
DROP TABLE IF EXISTS catproducto CASCADE;
DROP TABLE IF EXISTS catprodprod CASCADE;
DROP TABLE IF EXISTS catempresa CASCADE;
DROP TABLE IF EXISTS catempemp CASCADE;

create table if not exists usuario
(id SERIAL primary key, 
 correo varchar(50),
 clave varchar(50),
 nombre varchar(50), 
 direccion varchar(50),
 edad int, 
 is_admin boolean DEFAULT false);
 
 create table if not exists empresa
 (id SERIAL primary key,
 correo varchar(40),
 clave varchar(30),
 nombre varchar(30),
 direccion varchar(50),
 restriccion_edad bool);
 
 create table if not exists producto
 (id SERIAL primary key,
 nombre varchar(30),
 precio int,
 stock int,
 url varchar(200),
 id_empresa SERIAL,
 constraint fk_customer
 	foreign key(id_empresa)
		references empresa(id));

create table if not exists metodocompra
(id SERIAL primary key,
nombre_metodo varchar(30),
tipo_pago varchar(30),
tipo_cambio varchar(30));

	
create table if not exists transaccion
(id SERIAL primary key,
id_metodo int,
monto int,
constraint fk_transaccion
	unique(id_metodo),
	foreign key(id_metodo)
		references metodocompra(id));

create table if not exists carrito
(id SERIAL primary key,
id_user int,
id_transaccion int,
fecha TIMESTAMP,
constraint fk_carrito
	foreign key (id_user)
		references usuario(id),
	unique(id_transaccion),
	foreign key (id_transaccion)
		references transaccion(id));
		
create table if not exists valoracion
(id SERIAL primary key,
id_user int,
id_empresa int,
puntuacion int,
comentario varchar(200),
favorito bool,
constraint fk_valoracion
	foreign key (id_user)
		references usuario(id),
	foreign key (id_empresa)
		references empresa(id));
		
create table if not exists carroproducto
(id SERIAL primary key,
id_carrito int,
id_producto int,
constraint fk_carroproducto
	foreign key (id_carrito)
		references carrito(id),
	foreign key (id_producto)
		references producto(id));
		
create table if not exists catproducto
(id SERIAL primary key,
nombre varchar(50));

create table if not exists catprodprod
(id SERIAL primary key,
id_catproducto int,
numero_serie int,
constraint fk_catprodprod
	foreign key (id_catproducto)
		references catproducto(id),
	foreign key (numero_serie)
		references producto(id));
		
create table if not exists catempresa
(id SERIAL primary key,
tipo_producto varchar(50));

create table if not exists catempemp
(id SERIAL primary key,
id_empresa int,
id_catempresa int,
constraint fk_catempemp
	foreign key (id_empresa)
		references empresa(id),
	foreign key (id_catempresa)
		references catempresa(id));