package entidades;

public class Astrobus {
	
	private int idNave;
	private int cantAsientos;
	private double distRecorrida;
	private double distService;
	private double distLimite;
	private String tiempoLibre;
	private String marca;
	private boolean estado;
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
	

}
