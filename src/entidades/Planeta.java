package entidades;


public class Planeta {

	private int idPlaneta;
	private String nombrePlaneta;
	private int coordenadaX;
	private int coordenadaY;
	private boolean estado;
	private String fecha_alta;
	private String fecha_baja;
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
	
	public Planeta() {		
	}
	@Override
	public String toString() {
		return "Planeta [idPlaneta=" + idPlaneta + ", nombrePlaneta=" + nombrePlaneta + ", coordenadaX=" + coordenadaX
				+",coordenadaY= "+coordenadaY+", estado=" + estado + ", fecha_alta=" + fecha_alta + ", fecha_baja=" + fecha_baja + ", motivo="
				+ motivo + "]";
	}
	

	
}