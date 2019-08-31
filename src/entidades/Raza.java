package entidades;

public class Raza {
	
	private int idRaza;
	private String nombre;
	private int peligrosidad;
	
	public Raza() {}
	
	public Raza(int idRaza, String nombre, int peligrosidad) {
		super();
		this.idRaza = idRaza;
		this.nombre = nombre;
		this.peligrosidad = peligrosidad;
	}
	
	public int getIdRaza() {
		return idRaza;
	}
	public void setIdRaza(int idRaza) {
		this.idRaza = idRaza;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPeligrosidad() {
		return peligrosidad;
	}
	public void setPeligrosidad(int peligrosidad) {
		this.peligrosidad = peligrosidad;
	}
	
	
}
