package unah.edu.poo;

import java.time.LocalDate;

public class Perro extends Animal{

	public Perro(String nombre, LocalDate fechaNacimiento) {
		super(nombre, fechaNacimiento);
	}

	@Override
	public void hablar() {
		System.out.println("Ladrar");
	}
}