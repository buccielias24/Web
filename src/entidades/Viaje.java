package entidades;


public class Viaje {

	private String salida;
	private String llegada;
	private Planeta origen;
	private Planeta destino;
	private Astrobus astrobus;
	
	public Viaje() {}
		
	
	public Planeta getOrigen() {
		return origen;
	}

	public void setOrigen(Planeta origen) {
		this.origen = origen;
	}

	public Planeta getDestino() {
		return destino;
	}

	public void setDestino(Planeta destino) {
		this.destino = destino;
	}

	public Astrobus getAstrobus() {
		return astrobus;
	}

	public void setAstrobus(Astrobus astrobus) {
		this.astrobus = astrobus;
	}

	
	public String getSalida() {
		return salida;
	}

	public void setSalida(String horaS) {
		this.salida = horaS;
	}

	public String getLlegada() {
		return llegada;
	}

	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}
}
