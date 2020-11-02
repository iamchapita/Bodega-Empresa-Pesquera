package unah.edu.poo;

public class GenerarDocumento {

	public Tesis generarTesis(){
		
		Informe tesis = new Tesis();
		tesis.addParte(new Portada());
		tesis.addParte(new Introduccion());
		tesis.addParte(new Conclusion());
		tesis.addParte(new Anexo());
		
		return (Tesis) tesis;
	}
	
	public Reporte generarReporte(){
		
		Informe reporte = new Reporte();
		reporte.addParte(new Portada());
		reporte.addParte(new Conclusion());
		
		return (Reporte) reporte;
	}
	
}
