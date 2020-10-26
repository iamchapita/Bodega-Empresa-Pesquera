create	database GestionVentas;
use GestionVentas;

create table Cliente(idCliente int primary key, saldo double, limCredito double, direccionCliente varchar(50));

create table Pedido(idPedido int primary key, fechaPedido varchar(10), idCliente int ,foreign key(idCliente) references Cliente(idCliente));

create table Articulo(idArticulo int primary key, precio int, descripcion varchar(50));

create table PedidoArticulo(idPedido int, idArticulo int, cantidad int, precio int, primary key(idArticulo, idPedido), 
	foreign key (idPedido) references Pedido(idPedido),
	foreign key (idArticulo) references Articulo(idArticulo));

create table Fabrica(idFabrica int primary key, telefono varchar(15));

create table Produce(idArticulo int, idFabrica int, cantidad int, primary key(idArticulo, idFabrica),
	foreign key (idArticulo) references Articulo(idArticulo),
    foreign key (idFabrica) references Fabrica(idFabrica));

