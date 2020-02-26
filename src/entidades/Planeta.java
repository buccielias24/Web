package entidades;


public class Planeta {

	private int idPlaneta;
	private String nombrePlaneta;
	private int coordenadaX;
	private int coordenadaY;
	private boolean estado;
	private int motivo;
	
	
	public int getIdPlaneta() {
		return idPlaneta;
	}
	public void setIdPlaneta(int idPlaneta) {
		this.idPlaneta = idPlaneta;
	}
	public String getNombrePlaneta() {
		return nombrePlaneta;
	}
	public void setNombrePlaneta(String nombrePlaneta) {
		this.nombrePlaneta = nombrePlaneta;
	}
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
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public int getMotivo() {
		return motivo;
	}
	public void setMotivo(int motivo) {
		this.motivo = motivo;
	}
	
	public Planeta() {		
	}
	
	public Planeta(String nombre, int coordX, int coordY)
	{
		this.nombrePlaneta=nombre;
		this.coordenadaX=coordX;
		this.coordenadaY=coordY;
	}
	
}