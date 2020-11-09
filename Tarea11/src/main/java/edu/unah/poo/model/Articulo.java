package edu.unah.poo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Articulo")
public class Articulo {

	@Id
	private int idArticulo;
	private String descripcion;
	private double precio;

	@OneToMany(mappedBy = "articulo")
	@JsonBackReference
	private List<PedidoArticulo> pedidosArticulos;

	public Articulo() {
	}

	public Articulo(int idArticulo, String descripcion, double precio) {
		this.idArticulo = idArticulo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
