create table if not exists usuario
(id_user int primary key, 
 correo varchar(40), 
 nombre varchar(30), 
 apellido varchar(30), 
 edad int, 
 is_admin bool);
 
 create table if not exists empresa
 (id_empresa int primary key,
 correo varchar(40),
 nombre varchar(30),
 apellido varchar(30),
 clave varchar(30),
 direccion varchar(50),
 restriccion_edad bool);
 
 create table if not exists producto
 (numero_serie int primary key,
 nombre varchar(30),
 precio int,
 id_empresa int,
 constraint fk_customer
 	foreign key(id_empresa)
		references empresa(id_empresa));
	
create table if not exists transaccion
(id_transaccion int primary key,
monto int);

create table if not exists carrito
(id_carrito int primary key,
id_user int,
id_transaccion int,
fecha TIMESTAMP,
constraint fk_carrito
	foreign key (id_user)
		references usuario(id_user),
	foreign key (id_transaccion)
		references transaccion(id_transaccion));
  
create table if not exists metodocompra
(id_metodo int primary key,
nombre_metodo varchar(30),
tipo_pago varchar(30),
tipo_cambio varchar(30));

create table if not exists metcomtransa
(id_metodo int,
id_transaccion int,
constraint fk_metcomtransa
	foreign key (id_metodo)
		references metodocompra(id_metodo),
	foreign key (id_transaccion)
		references transaccion(id_transaccion));
		
create table if not exists valoracion
(id_user int,
id_empresa int,
puntuacion int,
comentario varchar,
favorito bool,
constraint fk_valoracion
	foreign key (id_user)
		references usuario(id_user),
	foreign key (id_empresa)
		references empresa(id_empresa));
		
create table if not exists carroproducto
(id_carrito int,
numero_serie int,
constraint fk_carroproducto
	foreign key (id_carrito)
		references carrito(id_carrito),
	foreign key (numero_serie)
		references producto(numero_serie));
		
create table if not exists catproducto
(id_catproducto int primary key,
nombre varchar(50));

create table if not exists catprodprod
(id_catproducto int,
numero_serie int,
constraint fk_catprodprod
	foreign key (id_catproducto)
		references catproducto(id_catproducto),
	foreign key (numero_serie)
		references producto(numero_serie));
		
create table if not exists catempresa
(id_catempresa int primary key,
tipo_producto varchar(50));

create table if not exists catempemp
(id_empresa int,
id_catempresa int,
constraint fk_catempemp
	foreign key (id_empresa)
		references empresa(id_empresa),
	foreign key (id_catempresa)
		references catempresa(id_catempresa));
  