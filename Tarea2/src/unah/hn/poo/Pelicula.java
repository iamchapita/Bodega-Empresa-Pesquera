package unah.hn.poo;

import java.util.ArrayList;

public class Pelicula{

	private String titulo;
	private String sinopsis;
	private int año;
	private String genero;
	private String pais;
	private ArrayList<Director> directores = new ArrayList<Director>();
	private ArrayList<Guionista> guionistas = new ArrayList<Guionista>();
	private ArrayList<Actor> actores = new ArrayList<Actor>();
	
	public Pelicula(String titulo, String sinopsis, int año, String genero, String pais) {
		super();
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.año = año;
		this.genero = genero;
		this.pais = pais;
	}
	
	public void añadirDirector(Director director) {
		
		this.directores.add(director);
		
	}
	
	public void añadirActor(Actor actor) {
			
			this.actores.add(actor);
			
	}

	public void añadirGuionista(Guionista guionista) {
		
		this.guionistas.add(guionista);
		
	}
	
	public String mostrarPersonas() {
		
		String varAux = "";
		
		for(int i = 0; i < this.directores.size(); i++) {
			varAux += this.directores.get(i).toString();
		}
		
		for(int i = 0; i < this.actores.size(); i++) {
			varAux += this.actores.get(i).toString();
		}
		
		for(int i = 0; i<this.guionistas.size(); i++) {
			varAux += this.guionistas.get(i).toString();
		}
		
		return varAux;
	}

	@Override
	public String toString() {
		return "Pelicula:\n"+ 
				"Titulo: " + titulo + "\nSinopsis: " + sinopsis + "\nAño: " + año + "\nGenero: " + genero+"\n"+ 
				"Pais: " + pais + "\n"+ mostrarPersonas();
	}
	
	
	
}
