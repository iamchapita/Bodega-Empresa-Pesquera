package zoo;

public abstract class Animal {

	private int patas;

	public abstract void caminar();
	public abstract void comer();
	
	public Animal(int patas) {
		super();
		this.patas = patas;
	}

	public int getPatas() {
		return patas;
	}

	public void setPatas(int patas) {
		this.patas = patas;
	}
	
}
