package entidades;

public class Pasajero {

	private int dgu;
	private String nombre;
	
	public Pasajero() {}
	
	public Pasajero(int dgu, String nombre) {
		super();
		this.dgu = dgu;
		this.nombre = nombre;
	}
	
	public int getDgu() {
		return dgu;
	}
	public void setDgu(int dgu) {
		this.dgu = dgu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	
}
