package entidades;


public class Viaje {

	private int idViaje;
	private String salida;
	private String llegada;
	private int estado;
	private Planeta origen;
	private Planeta destino;
	private Astrobus astrobus;
	private Ciudadano pasajero;
	private double distancia;
	private int motivo;		
	private boolean frecuencia[]=new boolean[6];
	
	public Viaje() {}
		
	public boolean[] getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(boolean[] frecuencia) {
		this.frecuencia = frecuencia;
	}
	
	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public int getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
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

	public Ciudadano getPasajero() {
		return pasajero;
	}

	public void setPasajero(Ciudadano pasajero) {
		this.pasajero = pasajero;
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
	
	
		
	public int getMotivo() {
		return motivo;
	}

	public void setMotivo(int motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "Viaje [idViaje=" + idViaje + ", salida=" + salida + ", llegada=" + llegada + ", estado=" + estado
				+ ", origen=" + origen + ", destino=" + destino + ", astrobus=" + astrobus + ", pasajero=" + pasajero
				+ ", distancia=" + distancia + "]";
	}

}
