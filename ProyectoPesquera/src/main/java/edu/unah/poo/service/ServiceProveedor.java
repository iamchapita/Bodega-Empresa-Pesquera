package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Proveedor;
import edu.unah.poo.repository.RepositoryProveedor;

@Service
public class ServiceProveedor {

	@Autowired
	RepositoryProveedor repositoryProveedor;

	public Proveedor crearProveedor(Proveedor objProveedor) {
		return this.repositoryProveedor.save(objProveedor);
	}

	public List<Proveedor> listaProveedores() {
		return this.repositoryProveedor.findAll();
	}

	public Proveedor buscarProveedor(int idProveedor) {
		return this.repositoryProveedor.findById(idProveedor);
	}

}
