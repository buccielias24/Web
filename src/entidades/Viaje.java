package entidades;

public class Viaje {

	private int idViaje;
	private String salida;
	private String llegada;
	private boolean estado;
	private Planeta origen;
	private Planeta destino;
	private Astrobus astrobus;
	private Pasajero pasajero;
	
	public Viaje() {}
	
	public Viaje(Planeta oriGen, Planeta desTino, Astrobus astro, Pasajero pasaj, int idViaje, String salida, String llegad,boolean estado) {
		this.origen= oriGen;
		this.destino=desTino;
		this.astrobus=astro;
		this.pasajero=pasaj;
		this.idViaje = idViaje;
		this.salida=salida;
		this.llegada=llegad;
		this.estado = estado;
	}
	
	
	public int getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}
	
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

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

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getLlegada() {
		return llegada;
	}

	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}
		
}
