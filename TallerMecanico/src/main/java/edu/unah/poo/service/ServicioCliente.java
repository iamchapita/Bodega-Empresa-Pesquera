package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Cliente;
import edu.unah.poo.repository.RepositorioCliente;

@Service
public class ServicioCliente {

	@Autowired
	RepositorioCliente repositorioCliente;

	public void crearCliente(Cliente obj) {
		this.repositorioCliente.save(obj);
	}

	public List<Cliente> obtenerClientes() {
		return this.repositorioCliente.findAll();
	}

	public Cliente buscarCliente(int idCliente) {
		return this.repositorioCliente.findById(idCliente);
	}
}
