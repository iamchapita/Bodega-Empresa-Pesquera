package unah.edu.poo;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Humano implements ComportamientoHumano, AccionesComunes{

	private String nombre;
	private LocalDate fechaNacimiento;
	private ArrayList<Cancion> canciones = new ArrayList<Cancion>();
	
	public Humano(String nombre, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public void dormir() {
		System.out.println("Soy " + nombre + " y estoy durmiendo.");
	}
	
	@Override
	public void alimentarse() {
		System.out.println("Estoy comiendo");	
	}
	
	@Override
	public void hablar() {
		System.out.println("Hola, soy " + nombre + " y estoy hablando.");
	}
	
	@Override
	public void estudiar() {
		System.out.println("Estoy haciendo Tarea de POO.");	
	}
	
	@Override
	public String compararEdad(Humano h) {
		if(this.fechaNacimiento.isBefore(h.fechaNacimiento)) {
			return this.nombre;
		}
		return h.nombre;
	}
	
	@Override
	public void trabajar() {
		System.out.println("Seŕe el mejor ingeniero en Sistemas que ha\n"
				+ "existido con trabajo duro y principios correctos.");
	}
	
	@Override
	public void listarCanciones() {
		
		if(this.canciones.size() > 0) {
			System.out.println("Canciones:");
			for(int i = 0; i < this.canciones.size(); i++) {
				System.out.println("\t" + this.canciones.get(i).getNombre());
			}
		}	
	}
	
	@Override
	public void adicionarCancion(Cancion c) {
		this.canciones.add(c);
	}
	
	@Override
	public void buscarCancion(String nombre) {
		if(this.canciones.size() > 0) {
			for(int i = 0; i < this.canciones.size(); i++) {
				if(this.canciones.get(i).getNombre().equalsIgnoreCase(nombre)) {
					System.out.println(nombre);
					break;
				}
			}
		}
	}
	
	
	@Override
	public void eliminarCancion(String nombre) {
		if(this.canciones.size() > 0) {
			for(int i = 0; i < this.canciones.size(); i++) {
				if(this.canciones.get(i).getNombre() == nombre ) {
					this.canciones.remove(i);
					System.out.println(nombre + " eliminada.");
					break;
				}
			}
		}
	}
	
	
	
}	
	