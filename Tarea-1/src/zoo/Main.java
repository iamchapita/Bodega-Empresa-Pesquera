package zoo;

public class Main {

	public static void main(String[] args) {

		//Instancia de lista de Animales
		ListaDeAnimales listaDeAnimales = new ListaDeAnimales();
		
		//Instancias de Animal 
		Animal gato = new Gato(4);
		Animal pez = new Pez(0);
		Animal araña = new Araña(8);
		
		//Prueba de métodos
		gato.caminar();
		gato.comer();
		pez.caminar();
		pez.comer();
		araña.caminar();
		araña.comer();
		System.out.println("-----------------------------------------");
			
		//Instancia de clases Gato, Pez y Araña
		Gato gatoClase = new Gato(10);
		Pez pezClase = new Pez(0);
		Araña arañaClase = new Araña(8);
		
		//Prueba de métodos
		gatoClase.setNombre("Misifú");
		pezClase.setNombre("Dory");
		arañaClase.setNombre("Doris");
		
		gatoClase.caminar(4);
		gatoClase.caminar();
		gatoClase.comer();
		gatoClase.jugar();

		pezClase.caminar();
		pezClase.comer();
		pezClase.jugar();
		
		arañaClase.caminar(5);
		arañaClase.caminar();
		arañaClase.comer();
		arañaClase.jugar();
		System.out.println("-----------------------------------------");
		
		//Añadiendo objetos a listaDeAnimales
		listaDeAnimales.añadir(gato);
		listaDeAnimales.añadir(pez);
		listaDeAnimales.añadir(araña);
		listaDeAnimales.añadir(gatoClase);
		
		//Probando Metodos de listaDeAnimales
		System.out.println(listaDeAnimales.eliminar(gatoClase));
		System.out.println(listaDeAnimales.buscar(gatoClase));
		listaDeAnimales.modificar(pez, 0);
		System.out.println("-----------------------------------------");
		
		
	}

}
