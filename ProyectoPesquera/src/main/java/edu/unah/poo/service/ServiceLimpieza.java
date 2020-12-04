package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Limpieza;
import edu.unah.poo.repository.RepositoryLimpieza;

@Service
public class ServiceLimpieza {

	@Autowired
	RepositoryLimpieza repositoryLimpieza;

	public Limpieza crearLimpieza(Limpieza objLimpieza) {
		return this.repositoryLimpieza.save(objLimpieza);
	}

	public List<Limpieza> listaLimpiezas() {
		return this.repositoryLimpieza.findAll();
	}

	public Limpieza buscarLimpieza(int idLimpieza) {
		
		return this.repositoryLimpieza.findById(idLimpieza);
		
	}
}
