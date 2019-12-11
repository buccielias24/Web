package entidades;


public class Resenia {
	
	private int puntaje;
	private String comentario;
	private Ciudadano usuario;
	private Planeta planeta;
	private String fecha;
	
	public Resenia() {}
	
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Ciudadano getUsuario() {
		return usuario;
	}

	public void setUsuario(Ciudadano usuario) {
		this.usuario = usuario;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}
}
