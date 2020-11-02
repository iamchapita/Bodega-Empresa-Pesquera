package unah.hn.poo;

public class Director extends Persona{

	public Director(String nombre, String apellido, String fechaNacimiento, String nacionalidad) {
		super(nombre, apellido, fechaNacimiento, nacionalidad);
		
	}

	@Override
	public String toString() {
		return "Director: \n" + super.toString();
	}

	
}
