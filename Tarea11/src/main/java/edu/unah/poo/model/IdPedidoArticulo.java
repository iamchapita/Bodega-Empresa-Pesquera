package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Embeddable
@JsonIgnoreProperties({ "hibernateLazyInitializer", "hander" })
public class IdPedidoArticulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "idPedido")
	private int idPedido;
	@Column(name = "idArticulo")
	private int idArticulo;

	public IdPedidoArticulo() {
	}

	public IdPedidoArticulo(int idPedido, int idArticulo) {
		this.idPedido = idPedido;
		this.idArticulo = idArticulo;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof IdPedidoArticulo) {
			IdPedidoArticulo tmpId = (IdPedidoArticulo) obj;
			if (this.idArticulo == tmpId.getIdArticulo() && this.idPedido == tmpId.getIdPedido()) {
				return true;
			}
		}

		return false;
	}

	public int hasCode() {
		return (int) this.idArticulo + this.idPedido;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

}
