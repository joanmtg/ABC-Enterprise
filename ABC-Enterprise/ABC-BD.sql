DROP TABLE IF EXISTS Clientes, Empleados, Sedes, Piezas, Automoviles, OrdenesTrabajo, Ventas, PiezasOrden  CASCADE;


CREATE TABLE Sedes (
    cod_sede serial NOT NULL,
    nombre_sede varchar(50) NOT NULL,
    direccion_sede varchar(50) NOT NULL,
    CONSTRAINT pk_sede PRIMARY KEY(cod_sede)
);


CREATE TABLE Clientes (
	id_cliente serial, 
	nombre varchar(80) NOT NULL, 
	direccion varchar(50) NOT NULL,
	telefono varchar(10) NOT NULL,
	email varchar(30) NOT NULL,
	CONSTRAINT pk_cliente PRIMARY KEY(id_cliente)
);

CREATE TABLE Empleados (
	identificacion char(15),
	nombre varchar(80) NOT NULL,
	password varchar(20) NOT NULL,
	edad char(2) NOT NULL,
	estado varchar(20) NOT NULL,
	telefono varchar(10) NOT NULL,
	email varchar(30) NOT NULL,
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
	CONSTRAINT pk_pieza PRIMARY KEY(cod_pieza)
);

CREATE TABLE Automoviles (
	cod_auto serial,
	marca varchar(20) NOT NULL,
	modelo varchar(10) NOT NULL,
	precio int NOT NULL,
	color varchar(20) NOT NULL,
	nombre varchar(20) NOT NULL,
	CONSTRAINT pk_auto PRIMARY KEY(cod_auto)
);

CREATE TABLE OrdenesTrabajo (
	cod_orden char(5),
	estado char(1) NOT NULL,
	descripcion varchar(100),
	cod_empleado char(5),
	CONSTRAINT fk_empleado FOREIGN KEY(cod_empleado)
	REFERENCES Empleados(identificacion),
	CONSTRAINT pk_orden PRIMARY KEY(cod_orden)
);

CREATE TABLE Ventas (
	cod_auto integer,
	cod_empleado char(5),
	id_cliente integer,
	fecha varchar(10) NOT NULL,
	total int NOT NULL,
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
	cod_orden char(5),
	CONSTRAINT fk_pieza FOREIGN KEY(cod_pieza)
	REFERENCES Piezas(cod_pieza),
	CONSTRAINT fk_orden FOREIGN KEY(cod_orden)
	REFERENCES OrdenesTrabajo(cod_orden),
	CONSTRAINT pk_piezasO PRIMARY KEY(cod_pieza, cod_orden)
);


--Se ingresan distintas Sedes
INSERT INTO sedes(nombre_sede, direccion_sede) VALUES ('Sede de Cali', 'Univalle');
INSERT INTO sedes(nombre_sede, direccion_sede) VALUES ('Sede Buga', 'Milagroso');
INSERT INTO sedes(nombre_sede, direccion_sede) VALUES ('Sede Palmira', 'Centro de Palmira');

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
('1423124', 'Joan Tovar', '1423124-20', '20', 'Activo', '3124879630', 
	'joan@uv.com', 'Ph.D', 'London', 'Jefe taller',3);

