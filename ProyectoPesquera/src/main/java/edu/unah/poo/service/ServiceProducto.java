package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Producto;
import edu.unah.poo.repository.RepositoryProducto;

@Service
public class ServiceProducto {

	@Autowired
	RepositoryProducto repositoryProducto;

	public Producto crearProducto(Producto objProducto) {
		return this.repositoryProducto.save(objProducto);
	}

	public List<Producto> listaProductos() {
		return this.repositoryProducto.findAll();
	}

	public Producto buscarProducto(int idProducto) {
		return this.repositoryProducto.findById(idProducto);
	}
}
