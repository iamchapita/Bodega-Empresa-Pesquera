package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Cargamento;
import edu.unah.poo.repository.RepositoryCargamento;

@Service
public class ServiceCargamento {

	@Autowired
	RepositoryCargamento repositoryCargamento;

	public Cargamento crearCargamento(Cargamento objCargamento) {
		return this.repositoryCargamento.save(objCargamento);
	}

	public List<Cargamento> listaCargamentos() {
		return this.repositoryCargamento.findAll();
	}

	public Cargamento buscarCargamento(int idCargamento) {
		return this.repositoryCargamento.findById(idCargamento);
	}

}
