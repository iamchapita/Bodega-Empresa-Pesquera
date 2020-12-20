package edu.unah.poo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Producto")

public class Producto{

	@Id
	private int idProducto;
	private int cantidadLatas;
	private String descripcion;
	private String fechaElab;
	private String fechaVenc;
	private double peso;
	private double precio;

	@ManyToOne
	@JoinColumn(name = "idPescado")
	@JsonBackReference
	private Pescado pescado;
	
	@OneToMany(mappedBy = "producto")
	@JsonBackReference
	private List<ProductoFactura> productosFacturas;

	public Producto() {
	}

	public Producto(int idProducto, int cantidadLatas, String descripcion, String fechaElab, String fechaVenc,
			double peso, double precio, Pescado pescado) {
		this.idProducto = idProducto;
		this.cantidadLatas = cantidadLatas;
		this.descripcion = descripcion;
		this.fechaElab = fechaElab;
		this.fechaVenc = fechaVenc;
		this.peso = peso;
		this.precio = precio;
		this.pescado = pescado;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public int getCantidadLatas() {
		return cantidadLatas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getFechaElab() {
		return fechaElab;
	}

	public String getFechaVenc() {
		return fechaVenc;
	}

	public double getPeso() {
		return peso;
	}

	public double getPrecio() {
		return precio;
	}

	public Pescado getPescado() {
		return pescado;
	}

	public List<ProductoFactura> getProductosFacturas() {
		return productosFacturas;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public void setCantidadLatas(int cantidadLatas) {
		this.cantidadLatas = cantidadLatas;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFechaElab(String fechaElab) {
		this.fechaElab = fechaElab;
	}

	public void setFechaVenc(String fechaVenc) {
		this.fechaVenc = fechaVenc;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setPescado(Pescado pescado) {
		this.pescado = pescado;
	}

	public void setProductosFacturas(List<ProductoFactura> productosFacturas) {
		this.productosFacturas = productosFacturas;
	}



}
