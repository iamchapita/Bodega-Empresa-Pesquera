package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Cargamento;

public interface RepositoryCargamento extends JpaRepository<Cargamento, Integer>{

	public Cargamento findById(int idCargamento);
}
