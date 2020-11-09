package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.IdPedidoArticulo;
import edu.unah.poo.model.PedidoArticulo;
import edu.unah.poo.repository.RepositoryPedidoArticulo;

@Service
public class ServicePedidoArticulo {

	@Autowired
	RepositoryPedidoArticulo repositoryPedidoArticulo;

	public void crearPedidoArticulo(PedidoArticulo pedidoArticulo) {
		this.repositoryPedidoArticulo.save(pedidoArticulo);
	}

	public PedidoArticulo buscarPedidoArticulo(IdPedidoArticulo id) {
		return this.repositoryPedidoArticulo.getOne(id);
	}

	public List<PedidoArticulo> obtenerPedidosArticulos() {
		return this.repositoryPedidoArticulo.findAll();
	}
}
