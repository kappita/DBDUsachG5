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
 is_admin bool);
 
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
 id_metodo SERIAL,
monto int,
constraint fk_transaccion
	foreign key(id_metodo)
		references metodocompra(id));

create table if not exists carrito
(id SERIAL primary key,
id_user SERIAL,
id_transaccion SERIAL,
fecha TIMESTAMP,
constraint fk_carrito
	foreign key (id_user)
		references usuario(id),
	foreign key (id_transaccion)
		references transaccion(id));
		
create table if not exists valoracion
(id SERIAL primary key,
id_user SERIAL,
id_empresa SERIAL,
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
id_carrito SERIAL,
id_producto SERIAL,
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
id_catproducto SERIAL,
numero_serie SERIAL,
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
id_empresa SERIAL,
id_catempresa SERIAL,
constraint fk_catempemp
	foreign key (id_empresa)
		references empresa(id),
	foreign key (id_catempresa)
		references catempresa(id));



INSERT INTO usuario VALUES(1, 'ignacio@lala.cl', '123', 'igansio', 'caloantune', 20, True);
INSERT INTO usuario VALUES(2, 'kleful@chino.cl', '1234', 'kleful', 'nashi', 19, True);
INSERT INTO usuario VALUES(3, 'lenecace@le.com', '1234', 'reno', 'nashe', 21, False);
INSERT INTO usuario VALUES(4, 'pancho@menti.ra', '1234', 'francisco', 'poto', 19, False);

INSERT INTO empresa VALUES(1, 'capcom@cap.com', '1234', 'CAPCOM', 'japón', False);
INSERT INTO empresa VALUES(2, 'savory@poto.cl', '1234', 'Savory', 'Chile', False);
INSERT INTO empresa VALUES(3, 'rockstar@games.com', '1234', 'Rockstar', 'USA', True);

INSERT INTO valoracion VALUES(1, 1, 1, 10, 'weno juego', True);
INSERT INTO valoracion VALUES(2, 2, 1, 3, 'subieron los precios', False);
INSERT INTO valoracion VALUES(3, 1, 2, 8, 'rico helao', True);
INSERT INTO valoracion VALUES(4, 1, 3, 7, 'saquen gta vi', True);
INSERT INTO valoracion VALUES(5, 2, 2, 8, 'Helao', False);
INSERT INTO valoracion VALUES(6, 4, 3, 2, 'no tiene a miku', False);

INSERT INTO metodocompra VALUES(1, 'Efectivo', 'Presencial', 'Efectivo');
INSERT INTO metodocompra VALUES(2, 'Transbank', 'Presencial', 'Digital');
INSERT INTO metodocompra VALUES(3, 'Redcompra', 'Online', 'Digital');
INSERT INTO metodocompra VALUES(4, 'Visa', 'Online', 'Digital');
INSERT INTO metodocompra VALUES(5, 'Mastercard', 'Online', 'Digital');





SELECT usuario.* FROM usuario, valoracion WHERE usuario.id = 2 AND usuario.id = valoracion.id_user;