DROP TABLE CLIENTE IF EXISTS ;
CREATE TABLE CLIENTE (nombre varchar(150) not null, apellido varchar(150) not null, dni int not null, clienteid int not null);
DROP TABLE COMPROBANTE IF EXISTS ;
CREATE TABLE COMPROBANTE (fecha DATE not null, lineas varchar(500), total DOUBLE not null, cantidad int not null, clienteid int not null, comprobanteid int not null);
DROP TABLE PRODUCTO IF EXISTS ;
CREATE TABLE PRODUCTO (descripcion varchar(150), precio DOUBLE not null, codigo int not null, cantidad int not null, productoid int not null);