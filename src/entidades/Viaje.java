package entidades;

public class Viaje {

	private int idViaje;
	private String diaSalida;
	private String horaSalida;
	private String horaLlegada;
	private String fechaSalida;
	private boolean estado;
	
	public Viaje() {}
	
	public Viaje(int idViaje, String diaSalida, String horaSalida, String horaLlegada, String fechaSalida,
			boolean estado) {
		super();
		this.idViaje = idViaje;
		this.diaSalida = diaSalida;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.fechaSalida = fechaSalida;
		this.estado = estado;
	}
	
	
	public int getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}
	public String getDiaSalida() {
		return diaSalida;
	}
	public void setDiaSalida(String diaSalida) {
		this.diaSalida = diaSalida;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public String getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
