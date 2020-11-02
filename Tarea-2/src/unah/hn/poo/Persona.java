package unah.hn.poo;

public abstract class Persona {

	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String nacionalidad;
	
	public Persona(String nombre, String apellido, String fechaNacimiento, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "\tNombre: " + nombre + "\n\tApellido: " + apellido + "\n";
	}
	
	
}
