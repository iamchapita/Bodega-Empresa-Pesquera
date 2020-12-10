package edu.unah.poo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.unah.poo.model.Cargamento;
import edu.unah.poo.model.Empleado;
import edu.unah.poo.model.Factura;
import edu.unah.poo.model.IdProductoFactura;
import edu.unah.poo.model.Limpieza;
import edu.unah.poo.model.Pescado;
import edu.unah.poo.model.Producto;
import edu.unah.poo.model.ProductoFactura;
import edu.unah.poo.model.Proveedor;
import edu.unah.poo.service.ServiceCargamento;
import edu.unah.poo.service.ServiceEmpleado;
import edu.unah.poo.service.ServiceFactura;
import edu.unah.poo.service.ServiceLimpieza;
import edu.unah.poo.service.ServicePescado;
import edu.unah.poo.service.ServiceProducto;
import edu.unah.poo.service.ServiceProductoFactura;
import edu.unah.poo.service.ServiceProveedor;

@org.springframework.stereotype.Controller
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
	ServiceProductoFactura ServiceProductoFactura;
	@Autowired
	ServiceProveedor serviceProveedor;

	@GetMapping("/")
	public String index() {
		return "inicio";
	}

	@GetMapping("/inicio")
	public String inicio() {
		return "inicio";
	}

	@GetMapping("/facturacion")
	public String facturacion() {
		return "facturacion";
	}

	@GetMapping("/consulta")
	public String consulta() {
		return "consulta";
	}

// ===================================================================================================================================
// Cargamento
// ===================================================================================================================================

	@GetMapping(value = "/cargamento")
	public String cargamento(Model model) {
		List<Empleado> empleados = this.serviceEmpleado.listaEmpleados();
		List<Pescado> pescados = this.servicePescado.listaPescados();
		List<Proveedor> proveedores = this.serviceProveedor.listaProveedores();
		model.addAttribute("empleados", empleados);
		model.addAttribute("pescados", pescados);
		model.addAttribute("proveedores", proveedores);

		return "cargamento";
	}

	@RequestMapping(value = "/cargamento/crearCargamento", method = RequestMethod.POST)
	public String crearCargamento(@RequestParam(name = "idCargamento") int idCargamento,
			@RequestParam(name = "calidad") int calidad, @RequestParam(name = "estado") String estado,
			@RequestParam(name = "pesoGlobal") String pesoGlobal, @RequestParam(name = "precioKilo") String precioKilo,
			@RequestParam(name = "idProveedor") String idProveedor, @RequestParam(name = "idPescado") String idPescado,
			@RequestParam(name = "idEmpleado") String idEmpleado) {

		Proveedor proveedor = serviceProveedor.buscarProveedor(Integer.parseInt(idProveedor));
		Pescado pescado = servicePescado.buscarPescado(Integer.parseInt(idPescado));
		Empleado empleado = serviceEmpleado.buscarEmpleado(Integer.parseInt(idEmpleado));
		Limpieza limpieza = serviceLimpieza.buscarLimpieza(0);

		Cargamento objCargamento = new Cargamento(idCargamento, calidad, estado, Double.parseDouble(pesoGlobal),
				Double.parseDouble(precioKilo), proveedor, pescado, empleado, limpieza);

		this.serviceCargamento.crearCargamento(objCargamento);

		return "redirect:/cargamento";
	}

	@RequestMapping(value = "cargamento/listaCargamentos", method = RequestMethod.GET)
	public String listaCargamento(Model model) {

		List<Cargamento> cargamentos = this.serviceCargamento.listaCargamentos();
		model.addAttribute("cargamentos", cargamentos);

		return "/consultas/listadoCargamentos";
	}

	@RequestMapping(value = "cargamento/buscarCargamento", method = RequestMethod.GET)
	public Cargamento buscarCargamento(@RequestParam(name = "idCargamento") int idCargamento) {

		return this.serviceCargamento.buscarCargamento(idCargamento);
	}

	@GetMapping("/cargamento/detalle/{idCargamento}")
	public String detalleCargamento(@PathVariable("idCargamento") int idCargamento, Model model) {

		Cargamento cargamento = this.serviceCargamento.buscarCargamento(idCargamento);
		model.addAttribute("cargamento", cargamento);

		return "consultas/detalleCargamento";
	}

// ===================================================================================================================================
// Empleado
// ===================================================================================================================================

	@GetMapping(value = "/empleado")
	public String empleado() {
		return "empleado";
	}

	@RequestMapping(value = "empleado/crearEmpleado", method = RequestMethod.POST)
	public String crearEmpleado(@RequestParam("idEmpleado") int idEmpleado, @RequestParam("direccion") String direccion,
			@RequestParam(name = "fechaContrato") String fechaContrato,
			@RequestParam(name = "fechaNacimiento") String fechaNacimiento,
			@RequestParam(name = "nombre") String nombre, @RequestParam(name = "puesto") String puesto,
			@RequestParam(name = "telefono") String telefono) {

		Empleado empleado = new Empleado(idEmpleado, direccion, fechaContrato, fechaNacimiento, nombre, puesto,
				telefono);

		this.serviceEmpleado.crearEmpleado(empleado);
		return "redirect:/empleado";
	}

	@RequestMapping(value = "empleado/listaEmpleados", method = RequestMethod.GET)
	public String listaEmpleados(Model model) {

		List<Empleado> empleados = this.serviceEmpleado.listaEmpleados();
		model.addAttribute("empleados", empleados);

		return "consultas/listadoEmpleados";
	}

	@RequestMapping(value = "empleado/buscarEmpleado", method = RequestMethod.GET)
	public Empleado buscarEmpleado(@RequestParam(name = "idEmpleado") int idEmpleado) {

		return this.serviceEmpleado.buscarEmpleado(idEmpleado);
	}

	@GetMapping("/empleado/detalle/{idEmpleado}")
	public String detalleEmpleado(@PathVariable("idEmpleado") int idEmpleado, Model model) {

		Empleado empleado = this.serviceEmpleado.buscarEmpleado(idEmpleado);
		model.addAttribute("empleado", empleado);

		return "consultas/detalleEmpleado";
	}

// ===================================================================================================================================
// Factura
// ===================================================================================================================================

	@GetMapping(value = "/factura")
	public String factura(Model model) {

		List<Empleado> empleados = this.serviceEmpleado.listaEmpleados();
		model.addAttribute("empleados", empleados);

		return "factura";
	}

	@RequestMapping(value = "/factura/crearFactura", method = RequestMethod.POST)
	public String crearFactura(@RequestParam(name = "idFactura") int idFactura,
			@RequestParam(value = "fecha") String fecha, @RequestParam(value = "lugarVenta") String lugarVenta,
			@RequestParam(value = "idVendedor") int idVendedor) {

		Empleado vendedor = this.serviceEmpleado.buscarEmpleado(idVendedor);

		Factura factura = new Factura(idFactura, fecha, 0.0, lugarVenta, 0.0, vendedor);

		this.serviceFactura.crearFactura(factura);
		return "redirect:/factura";
	}

	@RequestMapping(value = "/factura/listaFacturas", method = RequestMethod.GET)
	public List<Factura> listaFacturas() {

		return this.serviceFactura.listaFacturas();
	}

	@RequestMapping(value = "/factura/buscarFactura", method = RequestMethod.GET)
	public Factura buscarFactura(@RequestParam(name = "idFactura") int idFactura) {

		return this.serviceFactura.buscarFactura(idFactura);
	}

// ===================================================================================================================================
// Limpieza
// ===================================================================================================================================

	@GetMapping(value = "/limpieza")
	public String limpieza(Model model) {

		List<Empleado> empleados = this.serviceEmpleado.listaEmpleados();
		List<Cargamento> cargamentos = this.serviceCargamento.listaCargamentos();
		List<Empleado> empleadosLimpieza = new ArrayList<Empleado>();

		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getPuesto().contains("Limpieza")) {
				empleadosLimpieza.add(empleados.get(i));
			}
		}

		model.addAttribute("supervisores", empleados);
		model.addAttribute("empleados", empleadosLimpieza);
		model.addAttribute("cargamentos", cargamentos);

		return "limpieza";
	}

	@RequestMapping(value = "/limpieza/crearLimpieza", method = RequestMethod.POST)
	public String crearLimpieza(@RequestParam(name = "idLimpieza") int idLimpieza,
			@RequestParam(name = "horaFinal") String horaFinal, @RequestParam(name = "horaInicial") String horaInicial,
			@RequestParam(name = "idSupervisor") int idSupervisor,
			@RequestParam(name = "numEmpleados") int numEmpleados,
			@RequestParam(name = "idCargamentos") String idCargamentos) {

		String[] tmp = idCargamentos.split(",");
		Empleado supervisor = this.serviceEmpleado.buscarEmpleado(idSupervisor);
		Limpieza limpieza = new Limpieza(idLimpieza, horaFinal, horaInicial, numEmpleados, supervisor);

		this.serviceLimpieza.crearLimpieza(limpieza);

		for (int i = 0; i <= tmp.length - 1; i++) {

			Cargamento cargamento = this.serviceCargamento.buscarCargamento(Integer.parseInt(tmp[i]));
			cargamento.setLimpieza(limpieza);
			this.serviceCargamento.crearCargamento(cargamento);
		}

		return "redirect:/limpieza";
	}

	@RequestMapping(value = "/limpieza/listaLimpiezas", method = RequestMethod.GET)
	public String listaLimpiezas(Model model) {

		List<Limpieza> limpiezas = this.serviceLimpieza.listaLimpiezas();
		List<Cargamento> cargamentos = this.serviceCargamento.listaCargamentos();
		model.addAttribute("limpiezas", limpiezas);
		model.addAttribute("cargamentos", cargamentos);

		return "/consultas/listadoLimpiezas";
	}

	@RequestMapping(value = "/limpieza/buscarLimpieza", method = RequestMethod.GET)
	public Limpieza buscarLimpieza(@RequestParam(name = "idLimpieza") int idLimpieza) {

		return this.serviceLimpieza.buscarLimpieza(idLimpieza);
	}

	@GetMapping("/limpieza/detalle/{idLimpieza}")
	public String detalleLimpieza(@PathVariable("idLimpieza") int idLimpieza, Model model) {

		Limpieza limpieza = this.serviceLimpieza.buscarLimpieza(idLimpieza);
		model.addAttribute("limpieza", limpieza);

		return "consultas/detalleLimpieza";
	}

// ===================================================================================================================================
// Pescado
// ===================================================================================================================================

	@GetMapping(value = "/pescado")
	public String pescado() {
		return "pescado";
	}

	@RequestMapping(value = "/pescado/crearPescado", method = RequestMethod.POST)
	public String crearPescado(@RequestParam(name = "idPescado") int idPescado,
			@RequestParam(name = "color") String color, @RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "tamanioPromedio") double tamanioPromedio, @RequestParam(name = "tipo") String tipo) {

		Pescado pescado = new Pescado(idPescado, color, nombre, tamanioPromedio, tipo);

		this.servicePescado.crearPescado(pescado);

		return "redirect:/pescado";
	}

	@RequestMapping(value = "/pescado/listaPescados", method = RequestMethod.GET)
	public String listaPescados(Model model) {

		List<Pescado> pescados = this.servicePescado.listaPescados();
		model.addAttribute("pescados", pescados);

		return "/consultas/listadoPescados";
	}

	@RequestMapping(value = "/pescado/buscarPescado", method = RequestMethod.GET)
	public Pescado buscarPescado(@RequestParam(name = "idPescado") int idPescado) {

		return this.servicePescado.buscarPescado(idPescado);
	}

	@GetMapping("/pescado/detalle/{idPescado}")
	public String detallePescado(@PathVariable("idPescado") int idPescado, Model model) {

		Pescado pescado = this.servicePescado.buscarPescado(idPescado);
		model.addAttribute("pescado", pescado);

		return "consultas/detallePescado";
	}

// ===================================================================================================================================
// Producto
// ===================================================================================================================================

	@GetMapping(value = "/producto")
	public String producto(Model model) {

		List<Pescado> pescados = this.servicePescado.listaPescados();
		model.addAttribute("pescados", pescados);

		return "producto";
	}

	@RequestMapping(value = "/producto/crearProducto", method = RequestMethod.POST)
	public String crearProducto(@RequestParam(value = "idProducto") int idProducto,
			@RequestParam(value = "cantidadLatas") int cantidadLatas,
			@RequestParam(value = "descripcion") String descripcion,
			@RequestParam(value = "fechaElab") String fechaElab, @RequestParam(value = "fechaVenc") String fechaVenc,
			@RequestParam(value = "peso") double peso, @RequestParam(value = "precio") double precio,
			@RequestParam(value = "idPescado") int idPescado) {

		Pescado pescado = this.servicePescado.buscarPescado(idPescado);

		Producto producto = new Producto(idProducto, cantidadLatas, descripcion, fechaElab, fechaVenc, peso, precio,
				pescado);

		this.serviceProducto.crearProducto(producto);
		return "redirect:/producto";
	}

	@RequestMapping(value = "/producto/listaProductos")
	public String listaProductos(Model model) {

		List<Producto> productos = this.serviceProducto.listaProductos();
		model.addAttribute("productos", productos);

		return "/consultas/listadoProductos";
	}

	@RequestMapping(value = "/producto/buscarProducto")
	public Producto buscarProducto(@RequestParam(value = "idProducto") int idProducto) {

		return this.serviceProducto.buscarProducto(idProducto);
	}

	@GetMapping("/producto/detalle/{idProducto}")
	public String detalleProducto(@PathVariable("idProducto") int idProducto, Model model) {

		Producto producto = this.serviceProducto.buscarProducto(idProducto);
		model.addAttribute("producto", producto);

		return "consultas/detalleProducto";
	}

// ===================================================================================================================================
// ProductoFactura
// ===================================================================================================================================

	@GetMapping(value = "/agregarProducto")
	public String productoFactura(Model model) {

		List<Producto> productos = this.serviceProducto.listaProductos();
		List<Factura> facturas = this.serviceFactura.listaFacturas();
		model.addAttribute("productos", productos);
		model.addAttribute("facturas", facturas);

		return "agregarProducto";
	}

	@RequestMapping(value = "/productoFactura/crearProductoFactura", method = RequestMethod.POST)
	public String crearProductoFactura(@RequestParam(value = "idProducto") int idProducto,
			@RequestParam(value = "idFactura") int idFactura, @RequestParam(value = "cantidad") int cantidad) {

		Producto producto = this.serviceProducto.buscarProducto(idProducto);

		if (cantidad > producto.getCantidadLatas()) {

			return "errorCantidadLatas";

		}
		/*
		 * if(cantidad == 0){ ProductoFactura productoFactura =
		 * this.ServiceProductoFactura.buscarProductoFactura(id); if( productoFactura !=
		 * null) {
		 * producto.setCantidadLatas(producto.getCantidadLatas()+productoFactura.
		 * getCantidad()); double precioProdFactura = productoFactura.getPrecio();
		 * double isvProdFactura = productoFactura.getPrecio()*0.15; double total =
		 * factura.getTotal() - precioProdFactura; double isv = factura.getIsv() -
		 * isvProdFactura; factura.setTotal(total); factura.setIsv(isv);
		 * this.serviceFactura.crearFactura(factura); }else { return
		 * "redirect:/errorProductoFactura"; } }
		 */

		Factura factura = this.serviceFactura.buscarFactura(idFactura);
		IdProductoFactura id = new IdProductoFactura(idProducto, idFactura);
		
		double precio = producto.getPrecio();
		precio = precio * cantidad;

		double total = factura.getTotal();
		double isv = factura.getIsv();

		total = total + precio;
		isv = precio * 0.15 + isv;

		factura.setTotal(total);
		factura.setIsv(isv);

		producto.setCantidadLatas(producto.getCantidadLatas() - cantidad);

		this.serviceProducto.crearProducto(producto);
		this.serviceFactura.crearFactura(factura);

		ProductoFactura productoFactura = new ProductoFactura(id, cantidad, precio, factura, producto);
		this.ServiceProductoFactura.crearProductoFactura(productoFactura);

		return "redirect:/agregarProducto";
	}

	@RequestMapping(value = "/productoFactura/listaProductoFactura", method = RequestMethod.GET)
	public List<ProductoFactura> listaProductoFactura() {

		return this.ServiceProductoFactura.obtenerProductoFactura();
	}

	public ProductoFactura buscarProductoFactura(@RequestParam(value = "idProducto") int idProducto,
			@RequestParam(value = "idFactura") int idFactura) {

		IdProductoFactura idProductoFactura = new IdProductoFactura(idProducto, idFactura);

		return this.ServiceProductoFactura.buscarProductoFactura(idProductoFactura);
	}

// ===================================================================================================================================
// Proveedor
// ===================================================================================================================================

	@GetMapping(value = "/proveedor")
	public String proveedor() {
		return "proveedor";
	}

	@RequestMapping(value = "/proveedor/crearProveedor", method = RequestMethod.POST)
	public String crearProveedor(@RequestParam(name = "idProveedor") int idProveedor,
			@RequestParam(name = "nombre") String nombre) {

		Proveedor objProveedor = new Proveedor(idProveedor, nombre);
		this.serviceProveedor.crearProveedor(objProveedor);

		return "redirect:/proveedor";
	}

	@RequestMapping(value = "/proveedor/listaProveedores", method = RequestMethod.GET)
	public String listaProveedores(Model model) {

		List<Proveedor> proveedores = this.serviceProveedor.listaProveedores();

		model.addAttribute("proveedores", proveedores);

		return "consultas/listadoProveedores";
	}

	@RequestMapping(value = "/proveedor/buscarProveedor", method = RequestMethod.GET)
	public Proveedor buscarProveedor(@RequestParam(name = "idProveedor") int idProveedor) {

		return this.serviceProveedor.buscarProveedor(idProveedor);
	}

	@GetMapping("/proveedor/detalle/{idProveedor}")
	public String detalleProveedor(@PathVariable("idProveedor") int idProveedor, Model model) {

		Proveedor proveedor = this.serviceProveedor.buscarProveedor(idProveedor);
		model.addAttribute("proveedor", proveedor);

		return "consultas/detalleProveedor";
	}

}
