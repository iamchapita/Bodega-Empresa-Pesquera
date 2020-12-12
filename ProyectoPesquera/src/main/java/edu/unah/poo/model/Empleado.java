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
	private String contrasenia;
	private String direccion;
	private String fechaContrato;
	private String fechaNacimiento;
	private String nombre;
	private String puesto;
	private String telefono;
	private String usuario;

	@OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER)
	private List<Cargamento> cargamentos;

	@OneToMany(mappedBy = "supervisor", fetch = FetchType.LAZY)
	private List<Limpieza> limpiezas;

	@OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
	private List<Factura> facturas;

	public Empleado() {
	}

	public Empleado(int idEmpleado, String contrasenia, String direccion, String fechaContrato, String fechaNacimiento,
			String nombre, String puesto, String telefono, String usuario) {
		this.idEmpleado = idEmpleado;
		this.contrasenia = contrasenia;
		this.direccion = direccion;
		this.fechaContrato = fechaContrato;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.puesto = puesto;
		this.telefono = telefono;
		this.usuario = usuario;

	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getFechaContrato() {
		return fechaContrato;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public List<Cargamento> getCargamentos() {
		return cargamentos;
	}

	public List<Limpieza> getLimpiezas() {
		return limpiezas;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setFechaContrato(String fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setCargamentos(List<Cargamento> cargamentos) {
		this.cargamentos = cargamentos;
	}

	public void setLimpiezas(List<Limpieza> limpiezas) {
		this.limpiezas = limpiezas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

}
