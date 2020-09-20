package unah.edu.poo;

public class BuzzLightYear extends JugueteVolador {

	final String nombre = "BuzzLightYear";
	private int anioLanzamiento;
	
	public BuzzLightYear(int anioLanzamiento) {
		super();
		this.anioLanzamiento = anioLanzamiento;
	}

	@Override
	public void hablar() {
		System.out.println("Hola soy Buzz, mi sector es el cuadrante");
	}

	@Override
	public void volar() {
		System.out.println("Al infinito y mas allá");
	}

	public int getAnioLanzamiento() {
		return anioLanzamiento;
	}

	public void setAnioLanzamiento(int anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}

	public String getNombre() {
		return nombre;
	}
	
	

}
