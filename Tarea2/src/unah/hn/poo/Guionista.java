package unah.hn.poo;

public class Guionista extends Persona{

	public Guionista(String nombre, String apellido, String fechaNacimiento, String nacionalidad) {
		super(nombre, apellido, fechaNacimiento, nacionalidad);

	}

	@Override
	public String toString() {
		return "Guionista: \n" +super.toString();
	}
	
	

	
}
