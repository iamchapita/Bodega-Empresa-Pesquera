create database Pesquera;
use Pesquera;

CREATE TABLE Cargamento (
    idCargamento INT PRIMARY KEY,
    idEmpleado INT,
    idLimpieza INT,
    idPescado INT,
    idProveedor INT,
    calidad INT,
    estado VARCHAR(20),
    pesoGlobal DOUBLE,
    precioKilo DOUBLE,
    FOREIGN KEY (idEmpleado)
        REFERENCES Empleado (idEmpleado),
    FOREIGN KEY (idLimpieza)
        REFERENCES Limpieza (idLimpieza),
    FOREIGN KEY (idPescado)
        REFERENCES Pescado (idPescado),
    FOREIGN KEY (idProveedor)
        REFERENCES Proveedor (idProveedor)
);

CREATE TABLE Empleado (
    idEmpleado INT PRIMARY KEY,
    direccion VARCHAR(50),
    fechaContrato VARCHAR(20),
    fechaNacimiento VARCHAR(20),
    nombre VARCHAR(50),
    puesto VARCHAR(20),
    telefono VARCHAR(25)
);

CREATE TABLE Factura (
    idFactura INT PRIMARY KEY,
    idEmpleado INT,
    fecha VARCHAR(25),
    isv DOUBLE,
    lugarVenta VARCHAR(50),
    total DOUBLE,
    FOREIGN KEY (idEmpleado)
        REFERENCES Empleado (idEmpleado)
);

CREATE TABLE Limpieza (
    idLimpieza INT PRIMARY KEY,
    idSupervisor INT,
    horaFinal VARCHAR(50),
    horaInicio VARCHAR(50),
    numEmpleados INT,
    FOREIGN KEY (idSupervisor)
        REFERENCES Empleado (idEmpleado)
);

CREATE TABLE Pescado (
    idPescado INT PRIMARY KEY,
    color VARCHAR(20),
    nombre VARCHAR(20),
    tamanioPromedio DOUBLE,
    tipo VARCHAR(20)
);

CREATE TABLE Producto (
    idProducto INT PRIMARY KEY,
    idPescado INT,
    cantidadLatas INT,
    descripcion VARCHAR(25),
    fecha VARCHAR(20),
    peso DOUBLE,
    precio DOUBLE,
    FOREIGN KEY (idPescado)
        REFERENCES Pescado (idPescado)
);

CREATE TABLE ProductoFactura (
    idProducto INT,
    idFactura INT,
    cantidad INT,
    precio DOUBLE,
    PRIMARY KEY (idFactura , idProducto),
    FOREIGN KEY (idFactura)
        REFERENCES Factura (idFactura),
    FOREIGN KEY (idProducto)
        REFERENCES Producto (idProducto)
);

CREATE TABLE Proveedor (
    idProveedor INT PRIMARY KEY,
    nombre VARCHAR(25)
);


use Pesquera;
insert into Empleado values(0,"N/A","N/A","N/A","N/A","N/A","N/A");
insert into Limpieza values(0,0,"N/A","N/A",0);

SELECT * FROM Proveedor;
SELECT * FROM Empleado;
SELECT * FROM Limpieza;
SELECT * FROM Cargamento;

DELETE FROM Cargamento;
DELETE FROM Limpieza;
DELETE FROM Empleado;