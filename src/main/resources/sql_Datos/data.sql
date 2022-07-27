INSERT INTO CLIENTE
(nombre, apellido, dni, clienteid)
values
( 'Juan', 'Perez', 12345678, 1),
('Azucena', 'García', 23456789 ,2),
('Ibrian', 'Festorazzi', 23966789 ,3),
('Serafin' , 'Lopez', 34567890, 4);
INSERT INTO PRODUCTO
(descripcion, codigo, precio, cantidad, productoid)
values
( 'Pan', 'A123456789', 100, 15,1),
('Azucar', 'B223456789', 150,25,2),
('Agua', 'C323456789', 380,20,3),
('Carne' , 'D423456789', 2000, 15,4),
('Verduras' , 'E523456789', 500, 30,5),
('Lejia' , 'F23456789', 600, 2,6),
('Fosforos' , 'G723456789', 100, 1,7);
INSERT INTO COMPROBANTE (fecha, total, cantidad, clienteid, comprobanteid)
values
('2022-01-01',700,6,1,1),
('2022-02-01',3000,3,2,2);
INSERT INTO LISTADECOMPROBANTE (nombreproducto, precio, cantidad, productoid, comprobanteid)
values
('Pan',100,4,1,1),('Azucar',150,2,2,1),('Fosforos',100,4,7,1),
('Carne',2000,1,4,2),('Lejia',600,2,6,2);

