package edu.unah.poo.controller;

import java.util.List;

import org.aspectj.apache.bcel.classfile.NestHost;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	ServiceProductoFactura ServiceProductoFactura;
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

	@RequestMapping(value = "/factura/crearFactura", method = RequestMethod.GET)
	public Factura crearFactura(@RequestParam(name = "idFactura") int idFactura,
			@RequestParam(value = "fecha") String fecha,
			@RequestParam(value = "lugarVenta") String lugarVenta,
			@RequestParam(value = "total") double total,
			@RequestParam(value = "idVendedor") int idVendedor) {

		Empleado vendedor = this.serviceEmpleado.buscarEmpleado(idVendedor);
		double isv = total*0.15;
		
		Factura factura = new Factura(idFactura, fecha, isv, lugarVenta, total, vendedor);

		return this.serviceFactura.crearFactura(factura);
	}

	@RequestMapping(value = "/factura/listaFacturas", method = RequestMethod.GET)
	public List<Factura> listaFacturas() {

		return this.serviceFactura.listaFacturas();
	}

	@RequestMapping(value = "/factura/buscarFactura", method = RequestMethod.GET)
	public Factura buscarFactura(@RequestParam(name = "idFactura") int idFactura) {

		return this.serviceFactura.buscarFactura(idFactura);
	}
	
	@SuppressWarnings("unused")
	private double obtenerTotal(int idFactura) {

		List<Producto> productos = this.serviceProducto.listaProductos();
		double total = 0.0;

		for (int i = 1; i < productos.size(); i++) {

			int idProducto = productos.get(i).getIdProducto();
			ProductoFactura productoFactura = this.buscarProductoFactura(idProducto, idFactura);
			total = total + productoFactura.getPrecio();	
		}
		
		return total;
	}

		
// ===================================================================================================================================
// Limpieza
// ===================================================================================================================================

	@RequestMapping(value = "/limpieza/crearLimpieza", method = RequestMethod.GET)
	public Limpieza crearLimpieza(@RequestParam(name = "idLimpieza") int idLimpieza,
			@RequestParam(name = "horaFinal") String horaFinal, @RequestParam(name = "horaInicial") String horaInicial,
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
// Producto
// ===================================================================================================================================

	@RequestMapping(value = "/producto/crearProducto", method = RequestMethod.GET)
	public Producto crearProducto(@RequestParam(value = "idProducto") int idProducto,
			@RequestParam(value = "cantidadLatas") int cantidadLatas,
			@RequestParam(value = "descripcion") String descripcion,
			@RequestParam(value = "fechaElab") String fechaElab, @RequestParam(value = "peso") double peso,
			@RequestParam(value = "precio") double precio, @RequestParam(value = "idPescado") int idPescado) {

		Pescado pescado = this.servicePescado.buscarPescado(idPescado);
		Producto producto = new Producto(idProducto, cantidadLatas, descripcion, fechaElab, peso, precio, pescado);

		return this.serviceProducto.crearProducto(producto);
	}

	@RequestMapping(value = "/producto/listaProductos")
	public List<Producto> listaProductos() {

		return this.serviceProducto.listaProductos();
	}

	@RequestMapping(value = "/producto/buscarProducto")
	public Producto buscarProducto(@RequestParam(value = "idProducto") int idProducto) {

		return this.serviceProducto.buscarProducto(idProducto);
	}

// ===================================================================================================================================
// ProductoFactura
// ===================================================================================================================================

	@RequestMapping(value = "/productoFactura/crearProductoFactura", method = RequestMethod.GET)
	public ProductoFactura crearProductoFactura(@RequestParam(value = "idProducto") int idProducto,
			@RequestParam(value = "idFactura") int idFactura, @RequestParam(value = "cantidad") int cantidad) {

		IdProductoFactura id = new IdProductoFactura(idProducto, idFactura);
		Factura factura = this.serviceFactura.buscarFactura(idFactura);
		Producto producto = this.serviceProducto.buscarProducto(idProducto);

		double precio = this.serviceProducto.buscarProducto(idProducto).getPrecio();
		precio = precio * cantidad;

		ProductoFactura productoFactura = new ProductoFactura(id, cantidad, precio, factura, producto);

		return this.ServiceProductoFactura.crearProductoFactura(productoFactura);
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
