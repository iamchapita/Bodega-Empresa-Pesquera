package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Factura;
import edu.unah.poo.repository.RepositoryFactura;

@Service
public class ServiceFactura {

	@Autowired
	RepositoryFactura repositoryFactura;

	public Factura crearFactura(Factura objFactura) {
		return this.repositoryFactura.save(objFactura);
	}

	public List<Factura> listaFacturas() {
		return this.repositoryFactura.findAll();
	}

	public Factura buscarFactura(int idFactura) {
		return this.repositoryFactura.findById(idFactura);
	}
}
