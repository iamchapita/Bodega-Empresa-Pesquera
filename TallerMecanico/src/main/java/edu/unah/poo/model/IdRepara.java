package edu.unah.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Embeddable
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class IdRepara implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2608218813850943974L;
	private int idAuto;
	private int idMecanico;
	private LocalDate fecha;

	public IdRepara() {
	}

	public IdRepara(int idAuto, int idMecanico, LocalDate fecha) {
		super();
		this.idAuto = idAuto;
		this.idMecanico = idMecanico;
		this.fecha = fecha;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IdRepara) {
			IdRepara tmpId = (IdRepara) obj;
			if (this.idAuto == tmpId.getIdAuto() && this.idMecanico == tmpId.getIdMecanico()
					&& this.fecha.compareTo(tmpId.getFecha()) == 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public int hashCode() {
		return (int) this.fecha.hashCode() + this.idAuto + this.idMecanico;
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

}
