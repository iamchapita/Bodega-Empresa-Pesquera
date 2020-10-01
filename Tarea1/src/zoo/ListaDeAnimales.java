package zoo;

import java.util.ArrayList;

public class ListaDeAnimales{

	private ArrayList<Animal> listaDeAnimales= new ArrayList<Animal>();

	public ListaDeAnimales(){
			
	}

	public void añadir(Animal animal) {
		
		this.listaDeAnimales.add(animal);
	}

	public void modificar(Animal animal, int index) {
		
		if(this.buscar(animal) && index <= this.listaDeAnimales.size()) {
				
			this.listaDeAnimales.remove(animal);
			this.listaDeAnimales.set(index, animal);
						
		}
	
	}
	
	public boolean buscar(Animal animal) {
		
		for(int i = 0; i < this.listaDeAnimales.size(); i++) {
			
			if(this.listaDeAnimales.get(i).equals(animal)) {
				return true;
			}
			
		}
		
		return false;
	}
	
	public boolean eliminar(Animal animal) {
		
		return this.listaDeAnimales.remove(animal);
			
	}
		
}
