package unah.edu.poo;

import java.time.LocalDate;

public abstract class Animal implements AccionesComunes{

	private String nombre;
	private LocalDate fechaNacimiento;
	
	public Animal(String nombre, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public void dormir() {
		System.out.println("zzzZZZzzzZZZzzz");	
	}
	
	@Override
	public void alimentarse() {
		System.out.println("mmmmmmm");
	}
	
}
