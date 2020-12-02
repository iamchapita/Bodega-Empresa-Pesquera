package edu.unah.poo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Factura")

public class Factura {

	@Id
	private int idFactura;
	private LocalDate fecha;
	private double isv;
	private String lugarVenta;
	private double total;

	@ManyToOne
	@JoinColumn(name = "idEmpleado")
	@JsonBackReference
	private Empleado vendendor;

	@OneToMany(mappedBy = "Factura")
	private List<ProductoFactura> productosFacturas;

	public Factura() {
	}

	public Factura(int idFactura, LocalDate fecha, double isv, String lugarVenta, double total, Empleado vendendor) {
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.isv = isv;
		this.lugarVenta = lugarVenta;
		this.total = total;
		this.vendendor = vendendor;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getIsv() {
		return isv;
	}

	public void setIsv(double isv) {
		this.isv = isv;
	}

	public String getLugarVenta() {
		return lugarVenta;
	}

	public void setLugarVenta(String lugarVenta) {
		this.lugarVenta = lugarVenta;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Empleado getVendendor() {
		return vendendor;
	}

	public void setVendendor(Empleado vendendor) {
		this.vendendor = vendendor;
	}

}
