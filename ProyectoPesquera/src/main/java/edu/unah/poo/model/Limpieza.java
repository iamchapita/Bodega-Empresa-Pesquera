package edu.unah.poo.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Limpieza")

public class Limpieza {

	@Id
	private int idLimpieza;
	private int idSupervisor;
	private LocalTime horaFinal;
	private LocalTime horaInicial;
	private int numEmpleados;

	@ManyToOne
	@JoinColumn(name = "idSupervisor")
	@JsonBackReference
	private Empleado supervisor;

	public Limpieza() {
	}

	public Limpieza(int idLimpieza, int idSupervisor, LocalTime horaFinal, LocalTime horaInicial, int numEmpleados) {
		this.idLimpieza = idLimpieza;
		this.idSupervisor = idSupervisor;
		this.horaFinal = horaFinal;
		this.horaInicial = horaInicial;
		this.numEmpleados = numEmpleados;
	}

	public int getIdLimpieza() {
		return idLimpieza;
	}

	public void setIdLimpieza(int idLimpieza) {
		this.idLimpieza = idLimpieza;
	}

	public int getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(int idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	public LocalTime getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(LocalTime horaInicial) {
		this.horaInicial = horaInicial;
	}

	public int getNumEmpleados() {
		return numEmpleados;
	}

	public void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}

}
