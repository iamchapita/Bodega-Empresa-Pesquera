package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.IdRepara;
import edu.unah.poo.model.Repara;

public interface RepositorioRepara extends JpaRepository<Repara, IdRepara>{

}
