package entidades;

import java.util.Date;

public class Resenia {
	
	private int puntaje;
	private String comentario;
	private Ciudadano usuario;
	private Planeta planeta;
	private Date fecha;
	
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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
