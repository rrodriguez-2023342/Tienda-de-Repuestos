drop database if exists DB_Repuestos;
create database DB_Repuestos;
use DB_Repuestos;

create table Clientes(
	id_cliente int not null auto_increment,
    nombre_cliente varchar(100),
    apellido_cliente varchar(100),
    telefono_cliente varchar(100),
    correo_cliente varchar(100),
    primary key PK_id_cliente(id_cliente)
);
select * from clientes;

INSERT INTO Clientes(nombre_cliente, apellido_cliente, telefono_cliente, correo_cliente) 
	VALUES ('Carlos', 'Gómez', '5551001', 'carlos.gomez@example.com'),
		   ('Ana', 'Martínez', '5551002', 'ana.martinez@example.com'),
		   ('Luis', 'Fernández', '5551003', 'luis.fernandez@example.com'),
		   ('María', 'Ramírez', '5551004', 'maria.ramirez@example.com'),
		   ('José', 'Hernández', '5551005', 'jose.hernandez@example.com'),
		   ('Lucía', 'Pérez', '5551006', 'lucia.perez@example.com'),
		   ('Pedro', 'Castillo', '5551007', 'pedro.castillo@example.com'),
		   ('Marta', 'Morales', '5551008', 'marta.morales@example.com'),
		   ('Sofía', 'López', '5551009', 'sofia.lopez@example.com'),
		   ('Diego', 'Ruiz', '5551010', 'diego.ruiz@example.com');

create table Proveedores(
	id_proveedor int auto_increment,
    nombre_proveedor varchar(100),
    telefono_proveedor varchar(100),
    correo_proveedor varchar(100),
    direccion_proveedor varchar(100),
    primary key PK_id_proveedor(id_proveedor)
);
select * from proveedores;

INSERT INTO Proveedores(nombre_proveedor, telefono_proveedor, correo_proveedor, direccion_proveedor) 
	VALUES ('Autopartes S.A.', '5023001', 'contacto@autopartes.com', 'Zona 1, Ciudad de Guatemala'),
		   ('Motores y Más', '5023002', 'info@motoresymas.com', 'Zona 2, Ciudad de Guatemala'),
		   ('Repuestos Modernos', '5023003', 'ventas@repuestosmodernos.com', 'Zona 3, Ciudad de Guatemala'),
		   ('Importadora La Rueda', '5023004', 'import@larueda.com', 'Zona 4, Ciudad de Guatemala'),
		   ('Distribuidora El Motor', '5023005', 'ventas@elmotor.com', 'Zona 5, Ciudad de Guatemala'),
		   ('Autotech', '5023006', 'info@autotech.com', 'Zona 6, Ciudad de Guatemala'),
		   ('Repuestos GT', '5023007', 'ventas@repuestosgt.com', 'Zona 7, Ciudad de Guatemala'),
		   ('Partes Express', '5023008', 'contacto@partesexpress.com', 'Zona 8, Ciudad de Guatemala'),
		   ('Todo Repuesto', '5023009', 'info@todorepuesto.com', 'Zona 9, Ciudad de Guatemala'),
		   ('ServiCar', '5023010', 'ventas@servicar.com', 'Zona 10, Ciudad de Guatemala');

create table Repuestos(
	id_repuesto int auto_increment,
    nombre_repuesto varchar(100),
    precio double(10,2),
    stock int,
    id_proveedor int,
    primary key PK_id_repuesto(id_repuesto),
    constraint FK_id_proveedor foreign key (id_proveedor)
		references Proveedores(id_proveedor)
);
select * from Repuestos;

INSERT INTO Repuestos(nombre_repuesto, precio, stock, id_proveedor) 
	VALUES ('Batería 12V', 850.50, 20, 1),
		   ('Filtro de aceite', 120.75, 50, 2),
		   ('Pastillas de freno', 450.00, 35, 3),
		   ('Amortiguador trasero', 975.99, 15, 4),
		   ('Radiador', 1250.25, 10, 5),
		   ('Alternador', 2300.00, 12, 6),
		   ('Llanta 15"', 650.40, 40, 7),
		   ('Bomba de agua', 890.70, 18, 8),
		   ('Disco de freno', 780.10, 25, 9),
		   ('Correa de distribución', 560.80, 30, 10);

create table Ventas(
	id_venta int auto_increment,
    cantidad int,
    total double,
    id_repuesto int,
    id_cliente int,
    primary key PK_id_venta(id_venta),
	constraint FK_id_repuesto foreign key (id_repuesto)
		references Repuestos(id_repuesto),
	constraint FK_id_cliente_venta foreign key (id_cliente)
		references Clientes(id_cliente)
);
select * from Ventas;

INSERT INTO Ventas(cantidad, total, id_repuesto, id_cliente) 
	VALUES (2, 1701.00, 1, 1),   
		   (1, 120.75, 2, 2),    
		   (3, 1350.00, 3, 3),   
		   (1, 975.99, 4, 4),    
		   (2, 2500.50, 5, 5),   
		   (1, 2300.00, 6, 6),   
		   (4, 2601.60, 7, 7),   
		   (2, 1781.40, 8, 8),   
		   (1, 780.10, 9, 9),    
		   (3, 1682.40, 10, 10);