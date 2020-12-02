package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")

@Entity
@Table(name = "CargamentoLimpieza")
@IdClass(IdCargamentoLimpieza.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class CargamentoLimpieza implements Serializable {

	@Id
	private int idLimpieza;
	@Id
	private int idCargamento;

	@ManyToOne
	@JoinColumn(name = "idLimpieza", referencedColumnName = "idLimpieza", insertable = false, updatable = false)
	@JsonBackReference
	private Limpieza limpieza;

	@ManyToOne
	@JoinColumn(name = "idCargamento", referencedColumnName = "idCargamento", insertable = false, updatable = false)
	@JsonBackReference
	private Cargamento cargamento;

	public CargamentoLimpieza() {
	}

	public CargamentoLimpieza(int idLimpieza, int idCargamento, Limpieza limpieza, Cargamento cargamento) {
		this.idLimpieza = idLimpieza;
		this.idCargamento = idCargamento;
		this.limpieza = limpieza;
		this.cargamento = cargamento;
	}

	public int getIdLimpieza() {
		return idLimpieza;
	}

	public void setIdLimpieza(int idLimpieza) {
		this.idLimpieza = idLimpieza;
	}

	public int getIdCargamento() {
		return idCargamento;
	}

	public void setIdCargamento(int idCargamento) {
		this.idCargamento = idCargamento;
	}

	public Limpieza getLimpieza() {
		return limpieza;
	}

	public void setLimpieza(Limpieza limpieza) {
		this.limpieza = limpieza;
	}

	public Cargamento getCargamento() {
		return cargamento;
	}

	public void setCargamento(Cargamento cargamento) {
		this.cargamento = cargamento;
	}

}
