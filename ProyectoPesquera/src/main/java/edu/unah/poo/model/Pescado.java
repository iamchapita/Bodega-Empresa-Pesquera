package edu.unah.poo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Pescado")

public class Pescado {

	@Id
	private int idPescado;
	private String color;
	private String nombre;
	private double tamanioPromedio;
	private String tipo;

	@OneToMany(mappedBy = "pescado", fetch = FetchType.EAGER)
	private List<Cargamento> cargamentos;

	@OneToMany(mappedBy = "pescado", fetch = FetchType.LAZY)
	private List<Producto> productos;

	public Pescado() {
	}

	public Pescado(int idPescado, String color, String nombre, double tamanioPromedio, String tipo) {
		this.idPescado = idPescado;
		this.color = color;
		this.nombre = nombre;
		this.tamanioPromedio = tamanioPromedio;
		this.tipo = tipo;
	}

	public int getIdPescado() {
		return idPescado;
	}

	public void setIdPescado(int idPescado) {
		this.idPescado = idPescado;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTamanioPromedio() {
		return tamanioPromedio;
	}

	public void setTamanioPromedio(double tamanioPromedio) {
		this.tamanioPromedio = tamanioPromedio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
