create database TallerMecanico;
use TallerMecanico;

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY,
    nombre VARCHAR(20),
    direccion VARCHAR(50),
    telefono VARCHAR(15)
);

CREATE TABLE Auto (
    idAuto INT PRIMARY KEY,
    tipo VARCHAR(25),
    anio INT,
    idCliente INT,
    FOREIGN KEY (idCliente)
        REFERENCES Cliente (idCliente)
);

CREATE TABLE Mecanico (
    idMecanico INT PRIMARY KEY,
    nombre VARCHAR(25),
    usuario VARCHAR(25),
    contrasenia VARCHAR(25),
    rol VARCHAR(20)
);


CREATE TABLE Repara (
    idAuto INT,
    idMecanico INT,
    fecha VARCHAR(15),
    descripcion VARCHAR(50),
    precio DOUBLE,
    PRIMARY KEY (idAuto , idMecanico , fecha),
    FOREIGN KEY (idAuto)
        REFERENCES Auto (idAuto),
    FOREIGN KEY (idMecanico)
        REFERENCES Mecanico (idMecanico)
);


delete from Cliente;
delete from Auto;
delete from Mecanico;
delete from Repara;



