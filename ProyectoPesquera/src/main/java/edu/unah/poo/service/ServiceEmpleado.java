package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Empleado;
import edu.unah.poo.repository.RepositoryEmpleado;

@Service
public class ServiceEmpleado {

	@Autowired
	RepositoryEmpleado repositoryEmpleado;

	public Empleado crearEmpleado(Empleado objEmpleado) {
		return this.repositoryEmpleado.save(objEmpleado);
	}

	public List<Empleado> listaEmpleados() {
		return this.repositoryEmpleado.findAll();
	}

	public Empleado buscarEmpleado(int idEmpleado) {
		return this.repositoryEmpleado.findById(idEmpleado);
	}
}
