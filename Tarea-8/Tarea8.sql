create	database GestionVentas;
use GestionVentas;

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY,
    saldo DOUBLE,
    limCredito DOUBLE,
    direccion VARCHAR(50)
);

CREATE TABLE Pedido (
    idPedido INT PRIMARY KEY,
    fechaPedido VARCHAR(10),
    idCliente INT,
    FOREIGN KEY (idCliente)
        REFERENCES Cliente (idCliente)
);

CREATE TABLE Articulo (
    idArticulo INT PRIMARY KEY,
    precio DOUBLE,
    descripcion VARCHAR(50)
);

CREATE TABLE PedidoArticulo (
    idPedido INT,
    idArticulo INT,
    cantidad INT,
    precio INT,
    fecha VARCHAR(10),
    PRIMARY KEY (idArticulo , idPedido),
    FOREIGN KEY (idPedido)
        REFERENCES Pedido (idPedido),
    FOREIGN KEY (idArticulo)
        REFERENCES Articulo (idArticulo)
);

CREATE TABLE Fabrica (
    idFabrica INT PRIMARY KEY,
    telefono VARCHAR(15)
);

CREATE TABLE Produce (
    idArticulo INT,
    idFabrica INT,
    cantidad INT,
    PRIMARY KEY (idArticulo , idFabrica),
    FOREIGN KEY (idArticulo)
        REFERENCES Articulo (idArticulo),
    FOREIGN KEY (idFabrica)
        REFERENCES Fabrica (idFabrica)
);

use GestionVentas;
SELECT 
    *
FROM
    PedidoArticulo;
DELETE FROM Cliente;
DELETE FROM Pedido;
DELETE FROM Articulo;
DELETE FROM PedidoArticulo;
