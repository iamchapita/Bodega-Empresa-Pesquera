package unah.edu.poo;

import java.util.ArrayList;

public interface Documento {

	public String getTituloDocumento();
	public int getTamanio();
	public String getFecha();
	public ArrayList<Autor> getAutores();
	
}
