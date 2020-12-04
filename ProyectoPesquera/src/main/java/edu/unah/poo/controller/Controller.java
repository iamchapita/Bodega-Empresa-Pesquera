package edu.unah.poo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.unah.poo.model.Cargamento;
import edu.unah.poo.model.Empleado;
import edu.unah.poo.model.Limpieza;
import edu.unah.poo.model.Pescado;
import edu.unah.poo.model.Proveedor;
import edu.unah.poo.service.ServiceCargamento;
import edu.unah.poo.service.ServiceEmpleado;
import edu.unah.poo.service.ServiceFactura;
import edu.unah.poo.service.ServiceLimpieza;
import edu.unah.poo.service.ServicePescado;
import edu.unah.poo.service.ServiceProducto;
import edu.unah.poo.service.ServiceProveedor;

@RestController
public class Controller {

	@Autowired
	ServiceCargamento serviceCargamento;
	@Autowired
	ServiceEmpleado serviceEmpleado;
	@Autowired
	ServiceFactura serviceFactura;
	@Autowired
	ServiceLimpieza serviceLimpieza;
	@Autowired
	ServicePescado servicePescado;
	@Autowired
	ServiceProducto serviceProducto;
	@Autowired
	ServiceProveedor serviceProveedor;

// ===================================================================================================================================
// Cargamento
// ===================================================================================================================================

	@RequestMapping(value = "/cargamento/crearCargamento", method = RequestMethod.GET)
	public Cargamento crearCargamento(@RequestParam(name = "idCargamento") int idCargamento,
			@RequestParam(name = "calidad") int calidad, @RequestParam(name = "estado") String estado,
			@RequestParam(name = "pesoGlobal") double pesoGlobal, @RequestParam(name = "precioKilo") double precioKilo,
			@RequestParam(name = "idProveedor") int idProveedor, @RequestParam(name = "idPescado") int idPescado,
			@RequestParam(name = "idEmpleado") int idEmpleado, @RequestParam(name = "idLimpieza") int idLimpieza) {
		
		Proveedor proveedor = serviceProveedor.buscarProveedor(idProveedor);
		Pescado pescado = servicePescado.buscarPescado(idPescado);
		Empleado empleado = serviceEmpleado.buscarEmpleado(idEmpleado);
		Limpieza limpieza = serviceLimpieza.buscarLimpieza(idLimpieza);

		Cargamento objCargamento = new Cargamento(idCargamento, calidad, estado, pesoGlobal, precioKilo, proveedor,
				pescado, empleado, limpieza);

		return this.serviceCargamento.crearCargamento(objCargamento);
	}

	@RequestMapping(value = "cargamento/listaCargamentos", method = RequestMethod.GET)
	public List<Cargamento> listaCargamento() {
		return this.serviceCargamento.listaCargamentos();
	}

	@RequestMapping(value = "cargamento/buscarCargamento", method = RequestMethod.GET)
	public Cargamento buscarCargamento(@RequestParam(name = "idCargamento") int idCargamento) {
		return this.serviceCargamento.buscarCargamento(idCargamento);
	}

// ===================================================================================================================================
// Empleado
// ===================================================================================================================================

	@RequestMapping(value = "empleado/crearEmpleado", method = RequestMethod.GET)
	public Empleado crearEmpleado(@RequestParam("idEmpleado") int idEmpleado,
			@RequestParam("direccion") String direccion, @RequestParam(name = "fechaContrato") String fechaContrato,
			@RequestParam(name = "fechaNacimiento") String fechaNacimiento,
			@RequestParam(name = "nombre") String nombre, @RequestParam(name = "puesto") String puesto,
			@RequestParam(name = "telefono") String telefono) {

		Empleado empleado = new Empleado(idEmpleado, direccion, fechaContrato, fechaNacimiento, nombre, puesto,
				telefono);

		return this.serviceEmpleado.crearEmpleado(empleado);
	}

	@RequestMapping(value = "empleado/listaEmpleados", method = RequestMethod.GET)
	public List<Empleado> listaEmpleados() {
		return this.serviceEmpleado.listaEmpleados();
	}

	@RequestMapping(value = "empleado/buscarEmpleado", method = RequestMethod.GET)
	public Empleado buscarEmpleado(@RequestParam(name = "idEmpleado") int idEmpleado) {

		return this.serviceEmpleado.buscarEmpleado(idEmpleado);
	}

// ===================================================================================================================================
// Factura
// ===================================================================================================================================

// ===================================================================================================================================
// Limpieza
// ===================================================================================================================================

	@RequestMapping(value = "/limpieza/crearLimpieza", method = RequestMethod.GET)
	public Limpieza crearLimpieza(@RequestParam(name = "idLimpieza") int idLimpieza,
			@RequestParam(name = "horaFinal") String horaFinal,
			@RequestParam(name = "horaInicial") String horaInicial,
			@RequestParam(name = "idSupervisor") int idSupervisor,
			@RequestParam(name = "numEmpleados") int numEmpleados) {

		Empleado supervisor = this.serviceEmpleado.buscarEmpleado(idSupervisor);
		Limpieza limpieza = new Limpieza(idLimpieza, horaFinal, horaInicial, numEmpleados, supervisor);

		return this.serviceLimpieza.crearLimpieza(limpieza);
	}

	@RequestMapping(value = "/limpieza/listaLimpiezas", method = RequestMethod.GET)
	public List<Limpieza> listaLimpiezas() {
		return this.serviceLimpieza.listaLimpiezas();
	}

	@RequestMapping(value = "/limpieza/buscarLimpieza", method = RequestMethod.GET)
	public Limpieza buscarLimpieza(@RequestParam(name = "idLimpieza") int idLimpieza) {
		return this.serviceLimpieza.buscarLimpieza(idLimpieza);
	}

// ===================================================================================================================================
// Pescado
// ===================================================================================================================================

	@RequestMapping(value = "/pescado/crearPescado", method = RequestMethod.GET)
	public Pescado crearPescado(@RequestParam(name = "idPescado") int idPescado,
			@RequestParam(name = "color") String color, @RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "tamanioPromedio") double tamanioPromedio, @RequestParam(name = "tipo") String tipo) {

		Pescado pescado = new Pescado(idPescado, color, nombre, tamanioPromedio, tipo);

		return this.servicePescado.crearPescado(pescado);
	}

	@RequestMapping(value = "/pescado/listaPescados", method = RequestMethod.GET)
	public List<Pescado> listaPescados() {
		return this.servicePescado.listaPescados();
	}

	@RequestMapping(value = "/pescado/buscarPescado", method = RequestMethod.GET)
	public Pescado buscarPescado(@RequestParam(name = "idPescado") int idPescado) {
		return this.servicePescado.buscarPescado(idPescado);
	}

// ===================================================================================================================================
// Proveedor
// ===================================================================================================================================

	@RequestMapping(value = "proveedor/crearProveedor", method = RequestMethod.GET)
	public Proveedor crearProveedor(@RequestParam(name = "idProveedor") int idProveedor,
			@RequestParam(name = "nombre") String nombre) {
		Proveedor objProveedor = new Proveedor(idProveedor, nombre);
		return this.serviceProveedor.crearProveedor(objProveedor);
	}

	@RequestMapping(value = "proveedor/listaProveedores", method = RequestMethod.GET)
	public List<Proveedor> listaProveedores() {
		return this.serviceProveedor.listaProveedores();
	}

	@RequestMapping(value = "/proveedor/buscarProveedor", method = RequestMethod.GET)
	public Proveedor buscarProveedor(@RequestParam(name = "idProveedor") int idProveedor) {

		return this.serviceProveedor.buscarProveedor(idProveedor);
	}

}
