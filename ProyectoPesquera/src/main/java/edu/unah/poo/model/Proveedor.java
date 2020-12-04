package edu.unah.poo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Proveedor")

public class Proveedor {

	@Id
	private int idProveedor;
	private String nombre;

	@OneToMany(mappedBy = "proveedor", fetch = FetchType.EAGER)
	private List<Cargamento> cargamentos;

	public Proveedor() {
	}

	public Proveedor(int idProveedor, String nombre) {
		this.idProveedor = idProveedor;
		this.nombre = nombre;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
