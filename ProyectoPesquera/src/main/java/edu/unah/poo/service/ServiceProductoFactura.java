package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.IdProductoFactura;
import edu.unah.poo.model.ProductoFactura;
import edu.unah.poo.repository.RepositoryProductoFactura;

@Service
public class ServiceProductoFactura {

	@Autowired
	RepositoryProductoFactura repositoryProductoFactura;

	public ProductoFactura crearProductoFactura(ProductoFactura objProductoFactura) {

		return this.repositoryProductoFactura.save(objProductoFactura);
	}

	public ProductoFactura buscarProductoFactura(IdProductoFactura idProductoFactura) {
		return this.repositoryProductoFactura.getOne(idProductoFactura);
	}

	public List<ProductoFactura> obtenerProductoFactura() {
		return this.repositoryProductoFactura.findAll();
	}
		
}
