package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Auto;

public interface RepositorioAuto extends JpaRepository<Auto, Integer>{
	public Auto findById(int idAuto);
}
