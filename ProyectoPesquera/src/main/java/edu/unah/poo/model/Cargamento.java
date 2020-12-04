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
	@JoinColumn(name = "idLimpieza")
	@JsonBackReference
	private Limpieza limpieza;

	public Cargamento() {
	}

	public Cargamento(int idCargamento, int calidad, String estado, double pesoGlobal, double precioKilo,
			Proveedor proveedor, Pescado pescado, Empleado empleado, Limpieza limpieza) {
		this.idCargamento = idCargamento;
		this.calidad = calidad;
		this.estado = estado;
		this.pesoGlobal = pesoGlobal;
		this.precioKilo = precioKilo;
		this.proveedor = proveedor;
		this.pescado = pescado;
		this.empleado = empleado;
		this.limpieza = limpieza;
	}

	public int getIdCargamento() {
		return idCargamento;
	}

	public int getCalidad() {
		return calidad;
	}

	public String getEstado() {
		return estado;
	}

	public double getPesoGlobal() {
		return pesoGlobal;
	}

	public double getPrecioKilo() {
		return precioKilo;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public Pescado getPescado() {
		return pescado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public Limpieza getLimpieza() {
		return limpieza;
	}

	public void setIdCargamento(int idCargamento) {
		this.idCargamento = idCargamento;
	}

	public void setCalidad(int calidad) {
		this.calidad = calidad;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setPesoGlobal(double pesoGlobal) {
		this.pesoGlobal = pesoGlobal;
	}

	public void setPrecioKilo(double precioKilo) {
		this.precioKilo = precioKilo;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public void setPescado(Pescado pescado) {
		this.pescado = pescado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public void setLimpieza(Limpieza limpieza) {
		this.limpieza = limpieza;
	}

}
