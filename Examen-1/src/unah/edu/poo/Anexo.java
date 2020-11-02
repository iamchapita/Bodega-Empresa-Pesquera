package unah.edu.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Anexo extends ParteInforme{

	private String titulo = "Anexos";
	private int tamanio = 3;
	private LocalDate fecha = LocalDate.of(2020, 10, 07); 
	private List<Autor> autores = new ArrayList <Autor>();	
	
	public String getTituloDocumento() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	public int getTamanio() {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

	public String getFecha() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	public ArrayList<Autor> getAutores() {

		return (ArrayList<Autor>) this.autores; 
	}

	public void inicializarAnexo() {
		this.autores.add(new Autor(01,"Rosa", "editor"));
		this.autores.add(new Autor(02, "Luis", "supervisor"));
	}

}
