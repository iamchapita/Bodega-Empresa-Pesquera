package edu.unah.poo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	private int idCliente;
	private String direccion;
	private double limCredito;
	private double saldo;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<Pedido> pedidos;

	public Cliente() {
	}

	public Cliente(int idCliente, String direccion, double limCredito, double saldo) {
		this.idCliente = idCliente;
		this.direccion = direccion;
		this.limCredito = limCredito;
		this.saldo = saldo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getLimCredito() {
		return limCredito;
	}

	public void setLimCredito(double limCredito) {
		this.limCredito = limCredito;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
