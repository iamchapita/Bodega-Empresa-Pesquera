package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Mecanico;
import edu.unah.poo.repository.RepositorioMecanico;

@Service
public class ServicioMecanico {

	@Autowired
	RepositorioMecanico repositorioMecanico;

	public void crearMecanico(Mecanico obj) {
		this.repositorioMecanico.save(obj);
	}

	public List<Mecanico> obtenerMecanicos() {
		return this.repositorioMecanico.findAll();
	}

	public Mecanico buscarMecanico(int idMecanico) {
		return this.repositorioMecanico.findById(idMecanico);
	}
}
