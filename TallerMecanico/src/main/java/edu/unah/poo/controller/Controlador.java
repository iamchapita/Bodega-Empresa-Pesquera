package edu.unah.poo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.unah.poo.model.Auto;
import edu.unah.poo.model.Cliente;
import edu.unah.poo.model.IdRepara;
import edu.unah.poo.model.Mecanico;
import edu.unah.poo.model.Repara;
import edu.unah.poo.service.ServicioAuto;
import edu.unah.poo.service.ServicioCliente;
import edu.unah.poo.service.ServicioMecanico;
import edu.unah.poo.service.ServicioRepara;

@RestController
public class Controlador {

	@Autowired
	ServicioAuto servicioAuto;
	@Autowired
	ServicioCliente servicioCliente;
	@Autowired
	ServicioMecanico servicioMecanico;
	@Autowired
	ServicioRepara servicioRepara;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	// ===============================================================================================================//
	// Seguridad
	// ==============================================================================================================//

	String contrasenia = "123";


	// ===============================================================================================================//
	// Auto
	// ==============================================================================================================//
	@RequestMapping(value = "/auto/crearAuto", method = RequestMethod.GET)
	public Auto crearCliente(@RequestParam(name = "idAuto") int idAuto, @RequestParam(name = "tipo") String tipo,
			@RequestParam(name = "anio") int anio, @RequestParam(name = "idCliente") int idCliente) {

		Cliente cliente = this.servicioCliente.buscarCliente(idCliente);
		Auto auto = new Auto(idAuto, tipo, anio, cliente);
		this.servicioAuto.crearAuto(auto);
		return auto;

	}

	@RequestMapping(value = "/auto/listaAutos", method = RequestMethod.GET)
	public List<Auto> listaAutos() {
		return this.servicioAuto.obtenerAutos();
	}

	@RequestMapping(value = "/auto/buscarAuto", method = RequestMethod.GET)
	public Auto buscarAuto(@RequestParam(name = "idAuto") int idAuto) {
		return this.servicioAuto.buscartAuto(idAuto);
	}

	// ===============================================================================================================//
	// Cliente
	// ==============================================================================================================//
	@RequestMapping(value = "/cliente/crearCliente", method = RequestMethod.GET)
	public Cliente crearCliente(@RequestParam(name = "idCliente") int idCliente,
			@RequestParam(name = "nombre") String nombre, @RequestParam(name = "direccion") String direccion,
			@RequestParam(name = "telefono") String telefono) {

		Cliente cliente = new Cliente(idCliente, nombre, direccion, telefono);
		this.servicioCliente.crearCliente(cliente);
		return cliente;

	}

	@RequestMapping(value = "/cliente/listaClientes", method = RequestMethod.GET)
	public List<Cliente> listaClientes() {
		return this.servicioCliente.obtenerClientes();
	}

	@RequestMapping(value = "/cliente/buscarCliente", method = RequestMethod.GET)
	public Cliente buscarCliente(@RequestParam(name = "idCliente") int idCliente) {
		return this.servicioCliente.buscarCliente(idCliente);
	}

	// ===============================================================================================================//
	// Mecánico
	// ==============================================================================================================//
	@RequestMapping(value = "/mecanico/crearMecanico", method = RequestMethod.GET)
	public Mecanico crearMecanico(@RequestParam(name = "idMecanico") int idMecanico,
			@RequestParam(name = "nombre") String nombre, @RequestParam(name = "usuario") String usuario,
			@RequestParam(name = "contrasenia") String contrasenia, @RequestParam(name = "rol") String rol) {

		Mecanico mecanico = new Mecanico(idMecanico, nombre, usuario, contrasenia, rol);
		this.servicioMecanico.crearMecanico(mecanico);
		return mecanico;
	}

	@RequestMapping(value = "/mecanico/listaMecanicos", method = RequestMethod.GET)
	public List<Mecanico> listaMecanicos() {
		return this.servicioMecanico.obtenerMecanicos();
	}

	@RequestMapping(value = "/mecanico/buscarMecanicos", method = RequestMethod.GET)
	public Mecanico buscarMecanico(@RequestParam(name = "idMecanico") int idMecanico) {

		return this.servicioMecanico.buscarMecanico(idMecanico);
	}

	// ===============================================================================================================//
	// Repara
	// ==============================================================================================================//

	@RequestMapping(value = "/repara/crearRepara", method = RequestMethod.GET)
	public Repara crearRepara(@RequestParam(name = "idAuto") int idAuto,
			@RequestParam(name = "idMecanico") int idMecanico,
			@RequestParam(name = "fecha") @DateTimeFormat(iso = ISO.DATE) LocalDate fecha,
			@RequestParam(name = "precio") double precio, @RequestParam(name = "descripcion") String descripcion) {

		Auto auto = this.servicioAuto.buscartAuto(idAuto);
		Mecanico mecanico = this.servicioMecanico.buscarMecanico(idMecanico);
		Repara repara = new Repara(idAuto, idMecanico, fecha, precio, descripcion, auto, mecanico);

		this.servicioRepara.creaReparacion(repara);
		return repara;
	}

	@RequestMapping(value = "/repara/listaReparaciones", method = RequestMethod.GET)
	public List<Repara> listaReparaciones() {
		return this.servicioRepara.obtenerReparaciones();
	}

	@RequestMapping(value = "/repara/buscarRepara", method = RequestMethod.GET)
	public Repara buscarRepara(@RequestParam(name = "idAuto") int idAuto,
			@RequestParam(name = "idMecanico") int idMecanico,
			@RequestParam(name = "fecha") @DateTimeFormat(iso = ISO.DATE) LocalDate fecha) {

		IdRepara idRepara = new IdRepara(idAuto, idMecanico, fecha);
		return this.servicioRepara.buscarReparacion(idRepara);
	}

}
