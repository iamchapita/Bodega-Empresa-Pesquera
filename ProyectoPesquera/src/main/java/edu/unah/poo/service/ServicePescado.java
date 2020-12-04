package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Pescado;
import edu.unah.poo.repository.RepositoryPescado;

@Service
public class ServicePescado {

	@Autowired
	RepositoryPescado repositoryPescado;

	public Pescado crearPescado(Pescado objPescado) {
		return this.repositoryPescado.save(objPescado);
	}

	public List<Pescado> listaPescados() {
		return this.repositoryPescado.findAll();
	}

	public Pescado buscarPescado(int idPescado) {
		return this.repositoryPescado.findById(idPescado);
	}
}
