package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.IdPedidoArticulo;
import edu.unah.poo.model.PedidoArticulo;

public interface RepositoryPedidoArticulo extends JpaRepository<PedidoArticulo, IdPedidoArticulo> {

}
