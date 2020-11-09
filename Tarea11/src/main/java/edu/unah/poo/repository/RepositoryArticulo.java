package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Articulo;

public interface RepositoryArticulo extends JpaRepository<Articulo, Integer>{

	public Articulo findById(int idArticulo);
}
