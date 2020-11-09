package edu.unah.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PedidoArticulo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "hander" })
public class PedidoArticulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	IdPedidoArticulo idPedidoArticulo;

	private int cantidad;
	private LocalDate fecha;
	private double precio;

	@ManyToOne
	@MapsId("idPedidoInterno")
	@JoinColumn(name = "idPedido")
	private Pedido pedido;

	@ManyToOne
	@MapsId("idArticuloInterno")
	@JoinColumn(name = "idArticulo")
	private Articulo articulo;

	public PedidoArticulo() {
	}

	public PedidoArticulo(IdPedidoArticulo idPedidoArticulo, int cantidad, LocalDate fecha, double precio,
			Pedido pedido, Articulo articulo) {
		this.idPedidoArticulo = idPedidoArticulo;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.precio = precio;
		this.pedido = pedido;
		this.articulo = articulo;
	}

	public IdPedidoArticulo getIdPedidoArticulo() {
		return idPedidoArticulo;
	}

	public void setIdPedidoArticulo(IdPedidoArticulo idPedidoArticulo) {
		this.idPedidoArticulo = idPedidoArticulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
}
