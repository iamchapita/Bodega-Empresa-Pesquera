package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Cargamento")

public class Cargamento {

	@Id
	private int idCargamento;
	private int idEmpleado;
	private int idPez;
	private int idProveedor;
	private int calidad;
	private String estado;
	private double pesoGlobal;
	private double precioKilo;

	@ManyToOne
	@JoinColumn(name = "idProveedor")
	@JsonBackReference
	private Proveedor proveedor;

	@ManyToOne
	@JoinColumn(name = "idPescado")
	@JsonBackReference
	private Pescado pescado;

	@ManyToOne
	@JoinColumn(name = "idEmpleado")
	@JsonBackReference
	private Empleado empleado;

	public Cargamento() {
	}

	public Cargamento(int idCargamento, int idEmpleado, int idPez, int idProveedor, int calidad, String estado,
			double pesoGlobal, double precioKilo) {
		this.idCargamento = idCargamento;
		this.idEmpleado = idEmpleado;
		this.idPez = idPez;
		this.idProveedor = idProveedor;
		this.calidad = calidad;
		this.estado = estado;
		this.pesoGlobal = pesoGlobal;
		this.precioKilo = precioKilo;
	}

	public int getIdCargamento() {
		return idCargamento;
	}

	public void setIdCargamento(int idCargamento) {
		this.idCargamento = idCargamento;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdPez() {
		return idPez;
	}

	public void setIdPez(int idPez) {
		this.idPez = idPez;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getCalidad() {
		return calidad;
	}

	public void setCalidad(int calidad) {
		this.calidad = calidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getPesoGlobal() {
		return pesoGlobal;
	}

	public void setPesoGlobal(double pesoGlobal) {
		this.pesoGlobal = pesoGlobal;
	}

	public double getPrecioKilo() {
		return precioKilo;
	}

	public void setPrecioKilo(double precioKilo) {
		this.precioKilo = precioKilo;
	}

}
