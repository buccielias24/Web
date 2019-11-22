package entidades;


public class Resenia {
	
	private float puntaje;
	private String comentario;
	private int dgu;
	private int idPlaneta;
	private String fecha;
	
	public Resenia() {}
	
	public float getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getDgu() {
		return dgu;
	}
	public void setDgu(int dgu) {
		this.dgu = dgu;
	}
	public int getIdPlaneta() {
		return idPlaneta;
	}
	public void setIdPlaneta(int idPlaneta) {
		this.idPlaneta = idPlaneta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
