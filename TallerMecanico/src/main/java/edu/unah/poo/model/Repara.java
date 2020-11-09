package edu.unah.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Repara")
@IdClass(IdRepara.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Repara implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7032019940164967744L;
	@Id
	private int idAuto;
	@Id
	private int idMecanico;
	@Id
	private LocalDate fecha;
	private double precio;
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "idAuto", referencedColumnName = "idAuto", insertable = false, updatable = false)
	@JsonBackReference
	private Auto auto;

	@ManyToOne
	@JoinColumn(name = "idMecanico", referencedColumnName = "idMecanico", insertable = false, updatable = false)
	@JsonBackReference
	private Mecanico mecanico;

	public Repara() {
	}

	public Repara(int idAuto, int idMecanico, LocalDate fecha, double precio, String descripcion, Auto auto,
			Mecanico mecanico) {
		super();
		this.idAuto = idAuto;
		this.idMecanico = idMecanico;
		this.fecha = fecha;
		this.precio = precio;
		this.descripcion = descripcion;
		this.auto = auto;
		this.mecanico = mecanico;
	}

	public int getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}

	public int getIdMecanico() {
		return idMecanico;
	}

	public void setIdMecanico(int idMecanico) {
		this.idMecanico = idMecanico;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
