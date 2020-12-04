package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Embeddable
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class IdProductoFactura implements Serializable {

	@Column(name = "idProducto")
	private int idProducto;
	@Column(name = "idFactura")
	private int idFactura;

	public IdProductoFactura() {
	}

	public IdProductoFactura(int idProducto, int idFactura) {
		this.idProducto = idProducto;
		this.idFactura = idFactura;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof IdProductoFactura) {

			IdProductoFactura tmpId = (IdProductoFactura) obj;

			if (tmpId.getIdFactura() == this.getIdFactura() && tmpId.getIdProducto() == this.getIdProducto()) {
				return true;
			}
			return false;
		}

		return false;
	}

	public int hasCode() {
		return (int) this.getIdFactura() + this.getIdProducto();
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

}
