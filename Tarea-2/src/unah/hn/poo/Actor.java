package unah.hn.poo;

public class Actor extends Persona{

	public Actor(String nombre, String apellido, String fechaNacimiento, String nacionalidad) {
		super(nombre, apellido, fechaNacimiento, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Actor: \n" +super.toString();
	}
	
	

}
