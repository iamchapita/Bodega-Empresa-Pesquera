package unah.edu.poo;

import java.util.ArrayList;

public abstract class AbstractDocumento implements Documento{

	private String titulo;
	private int tamanio;
	private ArrayList<Autor> autores = new ArrayList<Autor>();
	
	public ArrayList<Autor> getAutores() {
		
		return this.autores;
	}
	
}
