package unah.edu.poo;

import java.util.ArrayList;
import java.util.List;

public abstract class Informe extends AbstractDocumento{
	
	private List<ParteInforme> partesInforme = new ArrayList<ParteInforme>();
	
	public boolean addParte(ParteInforme obj) {
		if(obj instanceof ParteInforme) { 
			this.partesInforme.add(obj);
			return true;
		}
		return false;
	}
	
	public String getAutor() {
		String var = "";
		
		for(ParteInforme obj: partesInforme) {
			for(Autor obj2: obj.getAutores()) {
				
				var += obj2.getNombre() +"\n";
			}
		}
		return var;
	}
	
	public int getTamanio() {
		
		int var = 0;
		for(int i=0; i < this.partesInforme.size(); i++) {
			var += this.partesInforme.get(i).getTamanio();
		}
		return var;
	}
	
	public boolean buscarAutorRol(String nombre, String rol) {
		
		for(ParteInforme obj: partesInforme) {
			for(Autor obj2: obj.getAutores()) {
				if(obj2.getNombre().contentEquals(nombre) && obj2.getRol().contentEquals(rol)) {
					return true;
				}
			}
		}
		return false;
	}
}
	
