package edu.unah.poo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "Producto")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Producto implements Serializable{

	@Id
	private int idProducto;
	private int cantidadLatas;
	private String descripcion;
	private String fechaElab;
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

	public Producto(int idProducto, int cantidadLatas, String descripcion, String fechaElab, double peso,
			double precio, Pescado pescado) {
		this.idProducto = idProducto;
		this.cantidadLatas = cantidadLatas;
		this.descripcion = descripcion;
		this.fechaElab = fechaElab;
		this.peso = peso;
		this.precio = precio;
		this.pescado = pescado;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidadLatas() {
		return cantidadLatas;
	}

	public void setCantidadLatas(int cantidadLatas) {
		this.cantidadLatas = cantidadLatas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaElab() {
		return fechaElab;
	}

	public void setFechaElab(String fechaElab) {
		this.fechaElab = fechaElab;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pescado getPescado() {
		return pescado;
	}

	public void setPescado(Pescado pescado) {
		this.pescado = pescado;
	}

}
