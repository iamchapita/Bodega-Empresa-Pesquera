package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Articulo;
import edu.unah.poo.repository.RepositoryArticulo;

@Service
public class ServiceArticulo {

	@Autowired
	RepositoryArticulo repositoryArticulo;

	public void crearArticulo(Articulo obj) {
		this.repositoryArticulo.save(obj);
	}

	public List<Articulo> obtenerArticulos() {
		return this.repositoryArticulo.findAll();
	}

	public Articulo buscarArticulo(int idArticulo) {
		return this.repositoryArticulo.findById(idArticulo);
	}
}
