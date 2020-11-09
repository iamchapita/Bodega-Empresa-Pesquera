package edu.unah.poo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.unah.poo.model.Articulo;
import edu.unah.poo.model.Cliente;
import edu.unah.poo.model.IdPedidoArticulo;
import edu.unah.poo.model.Pedido;
import edu.unah.poo.model.PedidoArticulo;
import edu.unah.poo.service.ServiceArticulo;
import edu.unah.poo.service.ServiceCliente;
import edu.unah.poo.service.ServicePedido;
import edu.unah.poo.service.ServicePedidoArticulo;

@RestController
public class Controller {

	@Autowired
	ServiceCliente serviceCliente;
	@Autowired
	ServiceArticulo serviceArticulo;
	@Autowired
	ServicePedido servicePedido;
	@Autowired
	ServicePedidoArticulo servicePedidoArticulo;

	// ===============================================================================================================//
	// Cliente
	// ==============================================================================================================//

	@RequestMapping(value = "/cliente/crearCliente", method = RequestMethod.GET)
	public Cliente crearCliente(@RequestParam(name = "idCliente") int idCliente,
			@RequestParam(name = "direccion") String direccion, 
			@RequestParam(name = "limCredito") double limCredito,
			@RequestParam(name = "saldo") double saldo) {

		Cliente tmpCliente = new Cliente(idCliente, direccion, limCredito, saldo);

		this.serviceCliente.crearCliente(tmpCliente);
		return tmpCliente;
	}

	@RequestMapping(value = "/cliente/listaClientes", method = RequestMethod.GET)
	public List<Cliente> listaClientes() {
		return this.serviceCliente.obtenerClientes();
	}

	@RequestMapping(value = "/cliente/buscarCliente", method = RequestMethod.GET)
	public Cliente buscarCliente(@RequestParam(name = "idCliente") int idCliente) {
		return this.serviceCliente.buscarCliente(idCliente);
	}

	// ===============================================================================================================//
	// Articulo
	// ==============================================================================================================//

	@RequestMapping(value = "/articulo/crearArticulo", method = RequestMethod.GET)
	public Articulo crearArticulo(@RequestParam(name = "idArticulo") int idArticulo,
			@RequestParam(name = "descripcion") String descripcion, 
			@RequestParam(name = "precio") double precio) {

		Articulo articulo = new Articulo(idArticulo, descripcion, precio);
		this.serviceArticulo.crearArticulo(articulo);
		return articulo;
	}

	@RequestMapping(value = "/articulo/listaArticulos", method = RequestMethod.GET)
	public List<Articulo> listaArticulo() {
		return this.serviceArticulo.obtenerArticulos();
	}

	@RequestMapping(value = "/articulo/buscarArticulo", method = RequestMethod.GET)
	public Articulo buscarArticulo(int idArticulo) {
		return this.serviceArticulo.buscarArticulo(idArticulo);
	}

	// ===============================================================================================================//
	// Pedido
	// ==============================================================================================================//

	@RequestMapping(value = "/pedido/crearPedido", method = RequestMethod.GET)
	public Pedido crearPedido(@RequestParam(name = "idPedido") int idPedido,
			@RequestParam(name = "idCliente") int idCliente) {
		
		LocalDate fechaPedido = LocalDate.now();
		Cliente tmpCliente = this.serviceCliente.buscarCliente(idCliente);
		Pedido tmpPedido = new Pedido(idPedido, fechaPedido, tmpCliente);
		
		this.servicePedido.crearPedido(tmpPedido);
		
		return tmpPedido;			
	}
	
	@RequestMapping(value="/pedido/listaPedidos", method = RequestMethod.GET)
	public List<Pedido> listaPedidos(){
		return this.servicePedido.listaPedidos();
	}
	
	@RequestMapping(value="/pedido/buscarPedido")
	public Pedido buscarPedido(int idPedido) {
		return this.servicePedido.buscarPedido(idPedido);
	}
	
	// ===============================================================================================================//
	// PedidoArticulo
	// ==============================================================================================================//
	
	@RequestMapping(value = "/pedidoArticulo/crearPedidoArticulo", method = RequestMethod.GET)
	public PedidoArticulo crearPedidoArticulo(@RequestParam(name="idPedido")int idPedido,
			@RequestParam(name="idArticulo")int idArticulo,
			@RequestParam(name="cantidad")int cantidad) {
		
		int precio; 
		IdPedidoArticulo idPedidoArticulo = new IdPedidoArticulo(idPedido, idArticulo);
		Pedido tmpPedido = this.servicePedido.buscarPedido(idPedido);
		Articulo tmpArticulo = this.serviceArticulo.buscarArticulo(idArticulo);
		LocalDate fechaPedido = LocalDate.now();
		
		precio = (int) (tmpArticulo.getPrecio()*cantidad);
		
		PedidoArticulo tmpPedidoArticulo = new PedidoArticulo(idPedidoArticulo, cantidad, fechaPedido, precio, tmpPedido, tmpArticulo);
		
		this.servicePedidoArticulo.crearPedidoArticulo(tmpPedidoArticulo);
		
		return tmpPedidoArticulo;
				
	}
	
	@RequestMapping(value = "/pedidoArticulo/buscarPedidoArticulo", method = RequestMethod.GET)
	public PedidoArticulo buscarPedidoArticulo(@RequestParam(name="idArticulo")int idArticulo, @RequestParam(name="idPedido") int idPedido) {
		
		IdPedidoArticulo idPedidoArticulo = new IdPedidoArticulo(idPedido, idArticulo);
		
		return this.servicePedidoArticulo.buscarPedidoArticulo(idPedidoArticulo);
	}
	
	@RequestMapping(value = "/pedidoArticulo/listaPedidosArticulos", method = RequestMethod.GET)
	public List<PedidoArticulo> listaPedidosArticulos(){
		return this.servicePedidoArticulo.obtenerPedidosArticulos();
	}
	
	
}
