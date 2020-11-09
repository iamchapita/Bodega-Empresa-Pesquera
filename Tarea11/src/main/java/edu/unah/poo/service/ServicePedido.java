package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Pedido;
import edu.unah.poo.repository.RepositoryPedido;

@Service
public class ServicePedido {

	@Autowired
	RepositoryPedido repositoryPedido;

	public Pedido crearPedido(Pedido objPedido) {
		return this.repositoryPedido.save(objPedido);
	}

	public List<Pedido> listaPedidos() {
		return this.repositoryPedido.findAll();
	}

	public Pedido buscarPedido(int idPedido) {
		return this.repositoryPedido.findById(idPedido);
	}
}
