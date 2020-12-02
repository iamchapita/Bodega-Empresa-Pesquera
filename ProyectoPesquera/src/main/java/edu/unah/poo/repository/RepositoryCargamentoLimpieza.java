package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.CargamentoLimpieza;
import edu.unah.poo.model.IdCargamentoLimpieza;

public interface RepositoryCargamentoLimpieza extends JpaRepository<CargamentoLimpieza, IdCargamentoLimpieza>{

}
