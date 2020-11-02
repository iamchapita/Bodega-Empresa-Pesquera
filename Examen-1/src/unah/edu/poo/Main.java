package unah.edu.poo;

public class Main {

	public static void main(String[] args) {
		
		GenerarDocumento objeto = new GenerarDocumento();
		System.out.println(objeto.generarTesis().buscarAutorRol("Miguel", "editor"));
	}

}
