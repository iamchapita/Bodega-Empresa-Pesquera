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
insert into Cliente values (1,1000.0,25000.0,"Palo Pintado");
insert into Cliente values (2,1000.0,25000.0,"Tronco Pintado");
insert into Pedido values(1,"2020-10-11",1);
insert into Pedido values(2,"2020-11-12",2);
insert into Articulo values(1,200.0, "Es un confite");
insert into Articulo values(2,300.0, "No es un confite");
SELECT 
    *
FROM
    PedidoArticulo;
DELETE FROM Cliente;
DELETE FROM Pedido;
DELETE FROM Articulo;
DELETE FROM PedidoArticulo;
