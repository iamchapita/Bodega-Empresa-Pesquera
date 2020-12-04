package edu.unah.poo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Empleado")

public class Empleado {

	@Id
	private int idEmpleado;
	private String direccion;
	private String fechaContrato;
	private String fechaNacimiento;
	private String nombre;
	private String puesto;
	private String telefono;

	@OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER)
	private List<Cargamento> cargamentos;

	@OneToMany(mappedBy = "supervisor", fetch = FetchType.LAZY)
	private List<Limpieza> limpiezas;

	@OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
	private List<Factura> facturas;

	public Empleado() {
	}

	public Empleado(int idEmpleado, String direccion, String fechaContrato, String fechaNacimiento, String nombre,
			String puesto, String telefono) {
		this.idEmpleado = idEmpleado;
		this.direccion = direccion;
		this.fechaContrato = fechaContrato;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.puesto = puesto;
		this.telefono = telefono;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(String fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
