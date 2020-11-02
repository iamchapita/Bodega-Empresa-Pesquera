package unah.edu.poo;

import java.time.LocalDate;

public class Gato extends Animal {

	public Gato(String nombre, LocalDate fechaNacimiento) {
		super(nombre, fechaNacimiento);
	}

	@Override
	public void hablar() {
		System.out.println("Maullar");
	}

}
