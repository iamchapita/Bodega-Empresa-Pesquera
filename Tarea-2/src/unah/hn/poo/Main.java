package unah.hn.poo;

public class Main {

	public static void main(String[] args) {
	
		
		Actor actor1 = new Actor("Marcos", "Perez", "03/04/1998", "Hondureño");
		Actor actor2= new Actor("Ana", "Perez", "03/04/1998", "Hondureño");
		Actor actor3 = new Actor("Emperatriz", "Perez", "03/04/1998", "Hondureño");
		Actor actor4 = new Actor("Jorge", "Perez", "03/04/1998", "Hondureño");
		Actor actor5 = new Actor("Maryori", "Perez", "03/04/1998", "Hondureño");
		Actor actor6 = new Actor("Cesia", "Perez", "03/04/1998", "Hondureño");
		Actor actor7 = new Actor("Celeste", "Perez", "03/04/1998", "Hondureño");
		
		Director director5 = new Director("Tara", "Quentin", "2020", "Salvadoreño");
		Director director6 = new Director("Tar", "Quentin", "2020", "Salvadoreño");
		Director director7 = new Director("Ta", "Quentin", "2020", "Salvadoreño");
		Director director8 = new Director("T", "Quentin", "2020", "Salvadoreño");
		Director director9 = new Director("Ta", "Quentin", "2020", "Salvadoreño");
		
		Guionista guionista5 = new Guionista("Paisa5", "Morales", "1939", "gringo");
		Guionista guionista6 = new Guionista("Paisa6", "Morales", "1939", "gringo");
		Guionista guionista7 = new Guionista("Paisa7", "Morales", "1939", "gringo");
		Guionista guionista8 = new Guionista("Paisa8", "Morales", "1939", "gringo");
		Guionista guionista9 = new Guionista("Paisa9", "Morales", "1939", "gringo");
		

		Pelicula Avengers = new Pelicula("Avengers End Game", "Los heroes mas poderosos del planeta", 2018, "Heroes", "Honduras");
		Avengers.añadirActor(actor7);
		Avengers.añadirActor(actor6);
		Avengers.añadirActor(actor5);
		Avengers.añadirActor(actor4);
		Avengers.añadirActor(actor3);
		Avengers.añadirActor(actor2);
		Avengers.añadirActor(actor1);
		Avengers.añadirDirector(director9);
		Avengers.añadirDirector(director8);
		Avengers.añadirDirector(director7);
		Avengers.añadirDirector(director6);
		Avengers.añadirDirector(director5);
		Avengers.añadirGuionista(guionista9);
		Avengers.añadirGuionista(guionista8);
		Avengers.añadirGuionista(guionista7);
		Avengers.añadirGuionista(guionista6);
		Avengers.añadirGuionista(guionista5);
		
		System.out.println(Avengers.toString());
		
		
		
	}

}
