DROP DATABASE IF EXISTS Pesquera;

CREATE DATABASE Pesquera;

USE Pesquera;

CREATE TABLE Empleado (
    idEmpleado INT PRIMARY KEY,
    contrasenia varchar(1000),
    direccion VARCHAR(50),
    fechaContrato VARCHAR(50),
    fechaNacimiento VARCHAR(50),
    nombre VARCHAR(50),
    puesto VARCHAR(50),
    telefono VARCHAR(50),
    usuario varchar(20)
);

CREATE TABLE Limpieza (
    idLimpieza INT PRIMARY KEY,
    idSupervisor INT,
    horaFinal VARCHAR(50),
    horaInicio VARCHAR(50),
    numEmpleados INT,
    FOREIGN KEY (idSupervisor) REFERENCES Empleado (idEmpleado)
);

CREATE TABLE Pescado (
    idPescado INT PRIMARY KEY,
    color VARCHAR(50),
    nombre VARCHAR(50),
    tamanioPromedio DOUBLE,
    tipo VARCHAR(50)
);

CREATE TABLE Producto (
    idProducto INT PRIMARY KEY,
    idPescado INT,
    cantidadLatas INT,
    descripcion VARCHAR(100),
    fechaElab VARCHAR(50),
    fechaVenc VARCHAR(50),
    peso DOUBLE,
    precio DOUBLE,
    FOREIGN KEY (idPescado) REFERENCES Pescado (idPescado)
);

CREATE TABLE Proveedor (
    idProveedor INT PRIMARY KEY,
    nombre VARCHAR(50)
);

CREATE TABLE Cargamento (
    idCargamento INT PRIMARY KEY,
    idEmpleado INT,
    idLimpieza INT,
    idPescado INT,
    idProveedor INT,
    calidad INT,
    estado VARCHAR(50),
    pesoGlobal DOUBLE,
    precioKilo DOUBLE,
    FOREIGN KEY (idEmpleado) REFERENCES Empleado (idEmpleado),
    FOREIGN KEY (idLimpieza) REFERENCES Limpieza (idLimpieza),
    FOREIGN KEY (idPescado) REFERENCES Pescado (idPescado),
    FOREIGN KEY (idProveedor) REFERENCES Proveedor (idProveedor)
);

CREATE TABLE Factura (
    idFactura INT PRIMARY KEY,
    idEmpleado INT,
    fecha VARCHAR(50),
    isv DOUBLE,
    lugarVenta VARCHAR(50),
    total DOUBLE,
    FOREIGN KEY (idEmpleado) REFERENCES Empleado (idEmpleado)
);

CREATE TABLE ProductoFactura (
    idProducto INT,
    idFactura INT,
    cantidad INT,
    precio DOUBLE,
    PRIMARY KEY (idFactura, idProducto),
    FOREIGN KEY (idFactura) REFERENCES Factura (idFactura),
    FOREIGN KEY (idProducto) REFERENCES Producto (idProducto)
);

/*
 use Pesquera;
 
 insert into
 Empleado
 values
 (
 0,
 "N/A",
 "N/A",
 "N/A",
 "N/A",
 "N/A",
 "N/A",
 "N/A",
 "N/A"
 );
 
 INSERT INTO 
 Limpieza
 VALUES
 (0, 0, "N/A", "N/A", 0);
 
 SELECT
 *
 FROM
 Proveedor;
 
 SELECT
 *
 FROM
 Empleado;
 
 SELECT
 *
 FROM
 Limpieza;
 
 SELECT
 *
 FROM
 Cargamento;
 
 SELECT
 *
 FROM
 Producto;
 
 SELECT
 *
 FROM
 Factura;
 
 SELECT
 *
 FROM
 ProductoFactura;
 
 SELECT
 *
 FROM
 Pescado;
 
 SELECT
 *
 FROM
 Factura;
 
 DELETE FROM
 Factura;
 
 DELETE FROM
 ProductoFactura;
 
 DELETE FROM
 Limpieza;
 
 DELETE FROM
 Empleado; */

DESC Limpieza;