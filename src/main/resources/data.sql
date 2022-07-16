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
INSERT INTO COMPROBANTE (fecha, lineas, total, cantidad, clienteid, comprobanteid)
values
('2022-01-01','1-4-100;2-2-150;',700,6,1,1),
('2022-02-01','4-1-2000;5-2-500;',3000,3,2,2),
('2022-03-01','6-4-600;7-2-100;',2600,6,4,3),
('2022-01-24','1-4-100;2-2-150;4-1-2000;6-2-600',3900,9,3,4);