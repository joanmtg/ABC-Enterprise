DROP TABLE IF EXISTS Clientes, Empleados, Sedes, Piezas, Automoviles, OrdenesTrabajo, Ventas, PiezasOrden, ejemplaresAutos  CASCADE;


CREATE TABLE Sedes (
    cod_sede serial NOT NULL,
    nombre_sede varchar(50) NOT NULL,
    telefono varchar(10) NOT NULL,
    direccion_sede varchar(50) NOT NULL,
    CONSTRAINT pk_sede PRIMARY KEY(cod_sede)
);


CREATE TABLE Clientes (
	id_cliente serial, 
	nombre varchar(80) NOT NULL, 
	direccion varchar(50) NOT NULL,
	telefono varchar(10) NOT NULL,
	email varchar(80) NOT NULL,
	CONSTRAINT pk_cliente PRIMARY KEY(id_cliente)
);

CREATE TABLE Empleados (
	identificacion varchar(10),
	nombre varchar(80) NOT NULL,
	password varchar(20) NOT NULL,
	edad char(2) NOT NULL,
	estado varchar(20) NOT NULL,
	telefono varchar(10) NOT NULL,
	email varchar(80) NOT NULL,
	titulo varchar(30) NOT NULL,
	direccion varchar(50) NOT NULL,
	tipo varchar(20) NOT NULL,
	cod_sede integer NOT NULL,
	CONSTRAINT fk_sedeG FOREIGN KEY(cod_sede)
	REFERENCES Sedes(cod_sede),
	CONSTRAINT pk_empleado PRIMARY KEY(identificacion)
);


CREATE TABLE Piezas (
	cod_pieza serial,
	nombre varchar(40) NOT NULL,
	precio int NOT NULL,
	cantidad integer NOT NULL,
	CONSTRAINT pk_pieza PRIMARY KEY(cod_pieza)
);

CREATE TABLE Automoviles (
	cod_auto serial,
	marca varchar(20) NOT NULL,
	modelo varchar(4) NOT NULL,
	precio double precision NOT NULL,
	color varchar(20) NOT NULL,
	linea varchar(20) NOT NULL,
	placa char(7) NOT NULL DEFAULT 'Nuevo',					-- Se modifica cuando se realice la venta del vehículo
	estado varchar(15) NOT NULL, 							-- Estado: "En venta", "En taller" o "Vendido"
	CONSTRAINT pk_auto PRIMARY KEY(cod_auto)
);

CREATE TABLE OrdenesTrabajo (
	cod_orden serial,
	precio double precision,
	estado varchar(12) NOT NULL,
	descripcion varchar(100),
	fecha date NOT NULL,
	cod_empleado varchar(15),
	cod_auto integer,
	id_cliente integer,
	CONSTRAINT fk_cod_auto_ot FOREIGN KEY(cod_auto)
	REFERENCES Automoviles(cod_auto),
	CONSTRAINT fk_cliente_ot FOREIGN KEY(id_cliente)
	REFERENCES Clientes(id_cliente),
	CONSTRAINT fk_empleado FOREIGN KEY(cod_empleado)
	REFERENCES Empleados(identificacion),
	CONSTRAINT pk_orden PRIMARY KEY(cod_orden)
);

CREATE TABLE Ventas (
	cod_auto integer,
	cod_empleado varchar(15),
	id_cliente integer,
	fecha date NOT NULL,
	CONSTRAINT fk_ventaA FOREIGN KEY(cod_auto)
	REFERENCES Automoviles(cod_auto),
	CONSTRAINT fk_ventaV FOREIGN KEY(cod_empleado)
	REFERENCES Empleados(identificacion),
	CONSTRAINT fk_ventaC FOREIGN KEY(id_cliente)
	REFERENCES Clientes(id_cliente),
	CONSTRAINT pk_venta 
	PRIMARY KEY(cod_auto, cod_empleado, id_cliente)
);

CREATE TABLE PiezasOrden (
	cod_pieza integer,
	cod_orden integer,
	cantidad integer,
	CONSTRAINT fk_pieza FOREIGN KEY(cod_pieza)
	REFERENCES Piezas(cod_pieza),
	CONSTRAINT fk_orden FOREIGN KEY(cod_orden)
	REFERENCES OrdenesTrabajo(cod_orden),
	CONSTRAINT pk_piezasO PRIMARY KEY(cod_pieza, cod_orden)
);

CREATE TABLE ejemplaresAutos (
	cod_auto integer,
	numero_auto integer,
	CONSTRAINT fk_cod_auto_ej FOREIGN KEY (cod_auto)
	REFERENCES Automoviles(cod_auto),
	CONSTRAINT pk_ejempleares_autos PRIMARY KEY (cod_auto, numero_auto)
);


--Se ingresan distintas Sedes
INSERT INTO sedes(nombre_sede, direccion_sede, telefono) VALUES ('Sede de Cali', 'Univalle', '2877890');
INSERT INTO sedes(nombre_sede, direccion_sede, telefono) VALUES ('Sede Buga', 'Milagroso', '34567854');
INSERT INTO sedes(nombre_sede, direccion_sede, telefono) VALUES ('Sede Palmira', 'Centro de Palmira', '3678567');

--Se ingresan distintos empleados
INSERT INTO Empleados(identificacion, nombre, password, edad, estado, telefono, email, titulo, direccion, tipo, cod_sede) VALUES 
('123', 'Linus Torvalds', '123-30', '30', 'Activo', '3122914869', 
	'linus@likeaboss.com', 'Doctor', 'Ciudad Jardin', 'Vendedor',1);
	
INSERT INTO Empleados(identificacion, nombre, password, edad, estado, telefono, email, titulo, direccion, tipo, cod_sede) VALUES 
('1424386', 'Fabio Castaneda', '1424386-19', '19', 'Activo', '3104544435', 
	'fabio@uv.com', 'Ph.D', 'New York', 'Gerente',1);
	
INSERT INTO Empleados(identificacion, nombre, password, edad, estado, telefono, email, titulo, direccion, tipo, cod_sede) VALUES 
('1423437', 'Juan Pablo M', '1423437-20', '20', 'Activo', '3147859435', 
	'pablo@uv.com', 'Ph.D', 'Washington', 'Gerente',2);
	
INSERT INTO Empleados(identificacion, nombre, password, edad, estado, telefono, email, titulo, direccion, tipo, cod_sede) VALUES 
('1424599', 'Jhonier Calero', '1424599-18', '18', 'Activo', '3015687495', 
	'jhonier@uv.com', 'Ph.D', 'Los Angeles', 'Vendedor',2);

INSERT INTO Empleados(identificacion, nombre, password, edad, estado, telefono, email, titulo, direccion, tipo, cod_sede) VALUES 
('1668773', 'Tyrion Lannister', '1668773-40', '40', 'Activo', '3157489302', 
	'tyrion@uv.com', 'La mano', 'Castle Rock', 'Jefe de taller',2);	
	
INSERT INTO Empleados(identificacion, nombre, password, edad, estado, telefono, email, titulo, direccion, tipo, cod_sede) VALUES 
('1423124', 'Joan Tovar', '1423124-20', '20', 'Activo', '3124879630', 
	'joan@uv.com', 'Ph.D', 'London', 'Jefe de taller',3);

INSERT INTO Empleados(identificacion, nombre, password, edad, estado, telefono, email, titulo, direccion, tipo, cod_sede) VALUES 
('1107089', 'Sebastian Castaño', '1107089-21', '21', 'Activo', '3167053857', 
	'sebas@uv.com', 'Ingeniero', 'London', 'Vendedor',2);

--Ingreso de automóviles

INSERT INTO Automoviles (marca, modelo, precio, color, linea, placa, estado) 
			VALUES 		('Chevrolet', '2010', 20000000, 'Negro', 'Aveo','SRU-789', 'En taller');

INSERT INTO Automoviles (marca, modelo, precio, color, linea, placa, estado)
			VALUES 		('Chevrolet', '2011', 20000000, 'Gris', 'Aveo','UTP-123', 'En taller');

INSERT INTO Automoviles (marca, modelo, precio, color, linea, placa, estado)
			VALUES 		('Chevrolet', '2008', 20000000, 'Azul', 'Aveo','MWF-121', 'En taller');

INSERT INTO Automoviles (marca, modelo, precio, color, linea, placa, estado)
			VALUES 		('Chevrolet', '2012', 25000000, 'Blanco', 'Optra','XQE-109', 'En taller');

INSERT INTO Automoviles (marca, modelo, precio, color, linea, placa, estado)
			VALUES 		('Chevrolet', '2013', 25000000, 'Negro', 'Optra','LOR-945', 'Vendido');

INSERT INTO Automoviles (marca, modelo, precio, color, linea, placa, estado)
			VALUES 		('Chevrolet', '2010', 25000000, 'Rojo', 'Optra','SQO-427', 'Vendido');

INSERT INTO Automoviles (marca, modelo, precio, color, linea, estado)
			VALUES 		('Mazda', '2011', 28000000, 'Negro', 'Allegro', 'En venta');

INSERT INTO Automoviles (marca, modelo, precio, color, linea, estado)
			VALUES 		('Mazda', '2010', 28000000, 'Blanco', 'Allegro', 'En venta');

INSERT INTO Automoviles (marca, modelo, precio, color, linea, estado)
			VALUES 		('Mazda', '2012', 28000000, 'Gris', 'Allegro', 'En venta');

INSERT INTO Automoviles (marca, modelo, precio, color, linea, estado)
			VALUES 		('Audi', '2011', 50000000, 'Plateado', 'R8', 'En venta');

INSERT INTO Automoviles (marca, modelo, precio, color, linea, estado)
			VALUES	    ('Audi', '2011', 50000000, 'Negro', 'R8', 'En venta');

INSERT INTO Automoviles (marca, modelo, precio, color, linea, estado)
			VALUES	    ('Audi', '2011', 50000000, 'Blanco', 'R8', 'En venta');
			

INSERT INTO Automoviles (marca, modelo, precio, color, linea, estado)
			VALUES ('Audi', '2012', 60000000, 'Azul', 'R10', 'En venta');			

--Ingreso de Piezas

INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Alarma', 30000, 10);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Aceite para Motor', 15000, 5);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Airbag', 100000, 8);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Amortiguadores', 80000, 20);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Alternador', 60000, 12);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Barras estabilizadoras', 150000, 18);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Biela', 40000, 6);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Bobina', 120000, 9);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Bomba de agua', 70000, 14);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Cunas de motor', 100000, 15);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Discos de freno', 180000, 10);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Ejes', 200000, 20);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Filtro de aceite', 50000, 8);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Filtro de aire', 60000, 12);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Llanta', 150000, 40);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Puerta', 100000, 20);
INSERT INTO Piezas (nombre, precio, cantidad) VALUES ('Radiador', 30000, 14);

--INGRESO DE CLIENTES 

INSERT INTO Clientes (nombre, direccion, telefono, email) VALUES ('Alfred Pennyworth', 'Mansion Wayne', '5552130', 'buttler@gmail.com');
INSERT INTO Clientes (nombre, direccion, telefono, email) VALUES ('Barry Allen', 'Laboratorios Star', '3546789', 'flash@gmail.com');
INSERT INTO Clientes (nombre, direccion, telefono, email) VALUES ('Jon Snow', 'Winterfell', '4568912', 'got@gmail.com');


--INGRESO DE VENTA

INSERT INTO Ventas VALUES ('1', '1424599', '1', '2016-11-20');
INSERT INTO Ventas VALUES ('2', '123', '1', '2016-11-24');
INSERT INTO Ventas VALUES ('3', '1424599', '2', '2016-11-26');
INSERT INTO Ventas VALUES ('4', '1107089', '3', '2016-11-20');
INSERT INTO Ventas VALUES ('5', '123', '2', '2016-11-24');
INSERT INTO Ventas VALUES ('6', '1107089', '3', '2016-11-26');

--INGRESO ORDENES DE TRABAJO

INSERT INTO OrdenesTrabajo (precio, estado, descripcion, fecha, cod_empleado, cod_auto, id_cliente) 
			VALUES (200000, 'En Progreso', 'se realiza el cambio de aceite para el motor', '2016-12-03','1423124', '1', '1');	

INSERT INTO OrdenesTrabajo (precio, estado, descripcion, fecha, cod_empleado, cod_auto, id_cliente) 
			VALUES (300000, 'En Progreso', 'se cambia el radiador', '2016-12-01','1668773', '2', '2');

INSERT INTO OrdenesTrabajo (precio, estado, descripcion, fecha, cod_empleado, cod_auto, id_cliente) 
			VALUES (500000, 'En Progreso', 'se cambian los discos del freno', '2016-11-25', '1668773', '3', '3');			

INSERT INTO OrdenesTrabajo (precio, estado, descripcion, fecha, cod_empleado, cod_auto, id_cliente) 
			VALUES (700000, 'En Progreso', 'se cambian los Airbag', '2016-10-20', '1423124', '4', '1');


--INGRESO PIEZASORDEN

INSERT INTO PiezasOrden VALUES ('2', '1', 3);

INSERT INTO PiezasOrden VALUES ('17', '2', 5);

INSERT INTO PiezasOrden VALUES ('11', '3', 1);

INSERT INTO PiezasOrden VALUES ('3', '4', 2);

