package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Auto;
import edu.unah.poo.repository.RepositorioAuto;

@Service
public class ServicioAuto {

	@Autowired
	RepositorioAuto repositorioAuto;

	public void crearAuto(Auto obj) {
		this.repositorioAuto.save(obj);
	}

	public List<Auto> obtenerAutos() {
		return this.repositorioAuto.findAll();
	}

	public Auto obtenerAuto(int idAuto) {
		return this.repositorioAuto.findById(idAuto);
	}
}
