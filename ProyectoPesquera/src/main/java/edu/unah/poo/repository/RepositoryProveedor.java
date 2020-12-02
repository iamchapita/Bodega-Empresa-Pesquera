package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Proveedor;

public interface RepositoryProveedor extends JpaRepository<Proveedor,Integer>{

	public Proveedor findById(int idProveedor);
}
