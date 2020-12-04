package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "ProductoFactura")
@JsonIgnoreProperties({ "hibernatyLazyInitializer", "handler" })

public class ProductoFactura implements Serializable {

	@EmbeddedId
	IdProductoFactura id;
	private int cantidad;
	private double precio;

	@ManyToOne
	@MapsId("idFacturaProducto")
	@JoinColumn(name = "idFactura")
	Factura factura;

	@ManyToOne
	@MapsId("idProductoFactura")
	@JoinColumn(name = "idProducto")
	Producto producto;

	public ProductoFactura() {
	}

	public ProductoFactura(IdProductoFactura id, int cantidad, double precio, Factura factura, Producto producto) {
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.factura = factura;
		this.producto = producto;
	}

	public IdProductoFactura getId() {
		return id;
	}

	public void setId(IdProductoFactura id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
