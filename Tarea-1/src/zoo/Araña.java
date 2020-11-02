package zoo;

public class Araña extends Animal implements Mascota{

	private String nombre;
	
	public Araña(int patas) {
		super(patas);
		// TODO Auto-generated constructor stub
	}

	public void caminar(int patas) {
		setPatas(patas);
	}
	
	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		this.nombre = nombre;
		
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public void jugar() {
		
		System.out.println("Me llamo " + getNombre() + " y estoy jugando");
		
	}

	@Override
	public void caminar() {
		System.out.println(getPatas());
		
	}

	@Override
	public void comer() {
		System.out.println("Estoy comiendo Insectos");
		
	}
	

}
