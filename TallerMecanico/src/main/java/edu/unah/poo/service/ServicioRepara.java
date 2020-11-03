package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.IdRepara;
import edu.unah.poo.model.Repara;
import edu.unah.poo.repository.RepositorioRepara;

@Service
public class ServicioRepara {

	@Autowired
	RepositorioRepara repositorioRepara;

	public void creaReparacion(Repara reparacion) {
		this.repositorioRepara.save(reparacion);
	}

	public Repara buscarReparacion(IdRepara idRepara) {
		return this.repositorioRepara.getOne(idRepara);
	}

	public List<Repara> obtenerReparaciones() {
		return this.repositorioRepara.findAll();
	}

}
