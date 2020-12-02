package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.IdProductoFactura;
import edu.unah.poo.model.ProductoFactura;

public interface RepositoryProductoFactura extends JpaRepository<ProductoFactura, IdProductoFactura>{

}
