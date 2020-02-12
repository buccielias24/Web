package entidades;

public class Astrobus {
	
	private String fecha_alta;
	private String fecha_baja;
	private int motivo;
	private String comentario;
	private int idNave;
	private int cantAsientos;
	private double distRecorrida;
	private double distService;
	private double distLimite;
	private String tiempoLibre;
	private String marca;
	private boolean estado;
	private int coordenadaX;
	private int coordenadaY;
	
	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	// Constructor de Astrobus
	public Astrobus() {
		
	}
	
	public Astrobus(String marca,int cantAsientos,double distService, double distLimite, boolean estado) {
		this.setMarca(marca);
		this.setCantAsientos(cantAsientos);
		this.setDistService(distService);
		this.setDistLimite(distLimite);
		this.setEstado(estado);
	}

	public int getIdNave() {
		return idNave;
	}
	public void setIdNave(int idNave) {
		this.idNave = idNave;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca=marca;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado= estado;
	}
	public int getCantAsientos() {
		return cantAsientos;
	}
	public void setCantAsientos(int cantAsientos) {
		this.cantAsientos = cantAsientos;
	}
	public double getDistRecorrida() {
		return distRecorrida;
	}
	public void setDistRecorrida(double distRecorrida) {
		this.distRecorrida = distRecorrida;
	}
	public double getDistService() {
		return distService;
	}
	public void setDistService(double distService) {
		this.distService = distService;
	}
	public double getDistLimite() {
		return distLimite;
	}
	public void setDistLimite(double distLimite) {
		this.distLimite = distLimite;
	}
	public String getTiempoLibre() {
		return tiempoLibre;
	}
	public void setTiempoLibre(String tiempoLibre) {
		this.tiempoLibre = tiempoLibre;
	}
	public String getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public String getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(String fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public int getMotivo() {
		return motivo;
	}

	public void setMotivo(int motivo) {
		this.motivo = motivo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Astrobus [fecha_alta=" + fecha_alta + ", fecha_baja=" + fecha_baja + ", motivo=" + motivo
				+ ", comentario=" + comentario + ", idNave=" + idNave + ", cantAsientos=" + cantAsientos
				+ ", distRecorrida=" + distRecorrida + ", distService=" + distService + ", distLimite=" + distLimite
				+ ", tiempoLibre=" + tiempoLibre + ", marca=" + marca + ", estado=" + estado + ", coordenadaX="
				+ coordenadaX + ", coordenadaY=" + coordenadaY + "]";
	}

	
}