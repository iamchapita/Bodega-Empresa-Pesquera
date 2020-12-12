package edu.unah.poo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Limpieza")

public class Limpieza {

	@Id
	private int idLimpieza;
	private String horaFinal;
	private String horaInicio;
	private int numEmpleados;

	@ManyToOne
	@JoinColumn(name = "idSupervisor")
	@JsonBackReference
	private Empleado supervisor;

	@OneToMany(mappedBy = "limpieza", fetch = FetchType.EAGER)
	private List<Cargamento> cargamentos;

	public Limpieza() {
	}

	public Limpieza(int idLimpieza, String horaFinal, String horaInicio, int numEmpleados, Empleado supervisor) {
		this.idLimpieza = idLimpieza;
		this.horaFinal = horaFinal;
		this.horaInicio = horaInicio;
		this.numEmpleados = numEmpleados;
		this.supervisor = supervisor;
	}

	public int getIdLimpieza() {
		return idLimpieza;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public int getNumEmpleados() {
		return numEmpleados;
	}

	public Empleado getSupervisor() {
		return supervisor;
	}

	public List<Cargamento> getCargamentos() {
		return cargamentos;
	}

	public void setIdLimpieza(int idLimpieza) {
		this.idLimpieza = idLimpieza;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}

	public void setSupervisor(Empleado supervisor) {
		this.supervisor = supervisor;
	}

	public void setCargamentos(List<Cargamento> cargamentos) {
		this.cargamentos = cargamentos;
	}

	}
