package implementacion.unah.edu.poo;

import java.time.LocalDate;

import unah.edu.poo.Animal;
import unah.edu.poo.Cancion;
import unah.edu.poo.Gato;
import unah.edu.poo.Hombre;
import unah.edu.poo.Humano;
import unah.edu.poo.Mujer;
import unah.edu.poo.Perro;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("-----------------------------------------------------------");
		//Agregando la fecha de hoy al objeto fecha1
		LocalDate fecha1 = LocalDate.now();
		//Agregando fecha1 al objeto humano1
		Humano humano1 = new Hombre("Fernando", fecha1);
		
		//Añadiendo canciones al objeto humano1
		humano1.adicionarCancion(new Cancion("La Mesa del Rincón", 1));
		humano1.adicionarCancion(new Cancion("Camelia La Texana", 2));
		humano1.adicionarCancion(new Cancion("Señor Locutor", 3));
		humano1.adicionarCancion(new Cancion("La Puerta Negra", 4));
		humano1.adicionarCancion(new Cancion("El Chofer", 5));
		/*
		//Listando canciones contenidas en ArrayList
		System.out.println("OBJETO HUMANO 1");
		System.out.println("-----------------------------------------------------------");
		humano1.listarCanciones();
		System.out.println("-----------------------------------------------------------");
		
		//Buscando canciones contenidas en el ArrayList
		humano1.buscarCancion("La Mesa del Rincón");
		
		System.out.println("-----------------------------------------------------------");
		//Eliminar canción contenida en el ArrayList
		humano1.eliminarCancion("Señor Locutor");
		
		System.out.println("-----------------------------------------------------------");
		//Buscando canciones contenidas en el ArrayList
		humano1.buscarCancion("Señor Locutor");
		
		System.out.println("-----------------------------------------------------------");
		//Probando métodos 
		humano1.hablar();
		humano1.dormir();
		humano1.alimentarse();
		humano1.estudiar();
		humano1.trabajar();
		
		//Agregando la fecha de 27/01/2020 al objeto fecha2
		LocalDate fecha2 = LocalDate.of(2020, 01, 27);
		
		//Agregando fecha2 al objeto humano2
		Humano humano2 = new Mujer("Luisa", fecha2);
		
		//Añadiendo canciones al objeto humano1
		humano2.adicionarCancion(new Cancion("La Incondicionl", 6));
		humano2.adicionarCancion(new Cancion("La Misma de Ayer", 7));
		humano2.adicionarCancion(new Cancion("Si No supiste Amar", 8));
		humano2.adicionarCancion(new Cancion("Almohada", 9));
		humano2.adicionarCancion(new Cancion("El Triste", 10));
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("OBJETO HUMANO 2");
		System.out.println("-----------------------------------------------------------");
		//Listando canciones contenidas en ArrayList
		humano2.listarCanciones();
		
		//Buscando canciones contenidas en el ArrayList
		humano2.buscarCancion("La Incondicional");
		
		System.out.println("-----------------------------------------------------------");
		//Eliminar canción contenida en el ArrayList
		humano2.eliminarCancion("Almohada");
		
		System.out.println("-----------------------------------------------------------");
		//Buscando canciones contenidas en el ArrayList
		humano2.buscarCancion("Almohada");
		
		System.out.println("-----------------------------------------------------------");
		//Probando métodos 
		humano2.hablar();
		humano2.dormir();
		humano2.alimentarse();
		humano2.estudiar();
		humano2.trabajar();
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("COMPARANDO EDADES DE OBJETOS");
		//Comparando Edad de humano1 con la edad de humano2
		System.out.println(humano1.compararEdad(humano2));
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("OBJETOS DEL TIPO ANIMAL");
		System.out.println("-----------------------------------------------------------");
		
		//Creando un objeto LocalDate
		LocalDate fecha3 = LocalDate.of(2015, 06, 1);
		
		//Instanciando un objeto del tipo Animal
		Animal animal1 = new Perro("Firulais", fecha3);
		
		//Prueba de Métodos
		animal1.alimentarse();
		animal1.dormir();
		animal1.hablar();
		
		System.out.println("-----------------------------------------------------------");
		//Creando un objeto LocalDate
		LocalDate fecha4 = LocalDate.of(2010, 06, 1);
		
		//Instanciando un objeto del tipo Animal
		Animal animal2 = new Gato("Misifú", fecha4);
		
		//Prueba de Métodos
		animal2.alimentarse();
		animal2.dormir();
		animal2.hablar();
		System.out.println("-----------------------------------------------------------");		
		*/
		System.out.println(humano1.getFechaNacimiento());
	}

}
