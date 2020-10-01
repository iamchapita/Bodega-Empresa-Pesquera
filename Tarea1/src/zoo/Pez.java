package zoo;

public class Pez extends Animal implements Mascota{

	private String nombre;
	
	public Pez(int patas) {
		super(patas);

	}
	
	public void jugar(String nombre) {
		
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public void jugar() {
		System.out.println("Me llamo "+getNombre()+ " y estoy jugando");
		
	}

	@Override
	public void caminar() {
		System.out.println(getPatas());
		
	}

	@Override
	public void comer() {
		
		System.out.println("Estoy comiendo mi comida");
		
	}
	
	

}
