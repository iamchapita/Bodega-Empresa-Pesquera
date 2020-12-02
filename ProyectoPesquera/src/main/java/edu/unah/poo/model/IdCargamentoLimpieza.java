package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Embeddable
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class IdCargamentoLimpieza implements Serializable {

	private int idLimpieza;
	private int idCargamento;

	public IdCargamentoLimpieza() {
	}

	public IdCargamentoLimpieza(int idLimpieza, int idCargamento) {
		this.idLimpieza = idLimpieza;
		this.idCargamento = idCargamento;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof IdCargamentoLimpieza) {

			IdCargamentoLimpieza tmpId = (IdCargamentoLimpieza) obj;

			if (this.idCargamento == tmpId.getIdCargamento() && this.idLimpieza == tmpId.getIdLimpieza()) {
				return true;
			}

			return false;
		}

		return false;
	}

	public int hashCode() {
		return (int) idCargamento + idLimpieza;
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

}
