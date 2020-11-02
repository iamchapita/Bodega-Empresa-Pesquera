CREATE DATABASE SistemaVentas;
USE SistemaVentas;

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY,
    nombre VARCHAR(20),
    telefono VARCHAR(15),
    correo VARCHAR(15),
    direccion VARCHAR(50)
);

CREATE TABLE Pedido (
    idPedido INT PRIMARY KEY,
    fechaPedido VARCHAR(15),
    direccionCliente VARCHAR(15),
    idCliente INT,
    FOREIGN KEY (idCliente)
        REFERENCES Cliente (idCliente)
);

CREATE TABLE Producto (
    idProducto INT PRIMARY KEY,
    idPedido INT,
    nombre VARCHAR(20),
    unidadMedida VARCHAR(10),
    precio INT,
    descripcion VARCHAR(20),
    FOREIGN KEY (idPedido)
        REFERENCES Pedido (idPedido)
);

CREATE TABLE Distribuidor (
    idDistribuidor INT PRIMARY KEY,
    idProducto INT,
    nombre VARCHAR(20),
    rtn VARCHAR(20),
    correo VARCHAR(20),
    FOREIGN KEY (idProducto)
        REFERENCES Producto (idProducto)
);

CREATE TABLE Empleado (
    idEmpleado INT PRIMARY KEY,
    idPedido INT,
    nombre VARCHAR(20),
    telefono VARCHAR(15),
    correo VARCHAR(15),
    direccion VARCHAR(20),
    FOREIGN KEY (idPedido)
        REFERENCES Pedido (idPedido)
);

CREATE TABLE Efectivo (
    tipo VARCHAR(20) PRIMARY KEY,
    idPedido INT,
    cambio DOUBLE,
    FOREIGN KEY (idPedido)
        REFERENCES Pedido (idPedido)
);

CREATE TABLE Tarjeta (
    numTarjeta VARCHAR(16) PRIMARY KEY,
    idPedido INT,
    tipo VARCHAR(10),
    codigoCVC INT,
    titular VARCHAR(20),
    fechaExp VARCHAR(15),
    FOREIGN KEY (idPedido)
        REFERENCES Pedido (idPedido)
);

CREATE TABLE PedidoProducto (
    idPedido INT,
    idProducto INT,
    cantidad INT,
    precio DOUBLE,
    PRIMARY KEY (idPedido , idProducto),
    FOREIGN KEY (idPedido)
        REFERENCES Pedido (idPedido),
    FOREIGN KEY (idProducto)
        REFERENCES Producto (idProducto)
);

CREATE TABLE ProductoDistribuidor (
    idProducto INT,
    idDistribuidor INT,
    cantidadDisponible DOUBLE,
    PRIMARY KEY (idProducto , idDistribuidor),
    FOREIGN KEY (idProducto)
        REFERENCES Producto (idProducto),
    FOREIGN KEY (idDistribuidor)
        REFERENCES Distribuidor (idDistribuidor)
);

CREATE TABLE PedidoDespacho (
    idPedido INT,
    idEmpleado INT,
    fechaEntrega VARCHAR(15),
    fechaCreacion VARCHAR(15),
    PRIMARY KEY (idPedido , idEmpleado),
    FOREIGN KEY (idPedido)
        REFERENCES Pedido (idPedido),
    FOREIGN KEY (idEmpleado)
        REFERENCES Empleado (idEmpleado)
);

CREATE TABLE PedidoPago (
    idPedido INT,
    tipo VARCHAR(20),
    numTarjeta VARCHAR(16),
    cargoEnvio DOUBLE,
    cargoPedido DOUBLE,
    isv DOUBLE,
    PRIMARY KEY (idPedido , tipo , numTarjeta),
    FOREIGN KEY (idPedido)
        REFERENCES Pedido (idPedido),
    FOREIGN KEY (tipo)
        REFERENCES Efectivo (tipo),
    FOREIGN KEY (numTarjeta)
        REFERENCES Tarjeta (numTarjeta)
);



