package unah.edu.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tesis extends Informe{

	private String titulo = "tesis";
	private int tamanio = 1;
	private LocalDate fecha = LocalDate.of(2020, 10, 8);
	private List<Autor> autores = new ArrayList<Autor>();
	
	public String getTituloDocumento() {
		// TODO Esbozo de método generado automáticamente
		return titulo;
	}

	public String getFecha() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	public ArrayList<Autor> getAutores() {

		return (ArrayList<Autor>) this.autores; 
	}

	public void inicializarTesis() {
		this.autores.add(new Autor(10,"Paola", "editor"));
	}

	@Override
	public String getAutor() {
		// TODO Esbozo de método generado automáticamente
		return super.getAutor();
	}

	@Override
	public int getTamanio() {
		// TODO Esbozo de método generado automáticamente
		return super.getTamanio();
	}

	public boolean buscarCreador(int idCreador, String rol) {
		
		for(Autor obj: autores) {
			if(obj.getId() == idCreador) {
				return true;
			}
		}
		return false;
	}
	
}
