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

	@ManyToOne
	@JoinColumn(name="idCargamento")
	@JsonBackReference
	private CargamentoLimpieza cargamentoLimpieza;
	
	public Cargamento() {
	}

	public Cargamento(int idCargamento, int calidad, String estado, double pesoGlobal, double precioKilo,
			Proveedor proveedor, Pescado pescado, Empleado empleado) {
		this.idCargamento = idCargamento;
		this.calidad = calidad;
		this.estado = estado;
		this.pesoGlobal = pesoGlobal;
		this.precioKilo = precioKilo;
		this.proveedor = proveedor;
		this.pescado = pescado;
		this.empleado = empleado;
	}

	public int getIdCargamento() {
		return idCargamento;
	}

	public void setIdCargamento(int idCargamento) {
		this.idCargamento = idCargamento;
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Pescado getPescado() {
		return pescado;
	}

	public void setPescado(Pescado pescado) {
		this.pescado = pescado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
