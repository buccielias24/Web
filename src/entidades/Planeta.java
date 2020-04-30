package entidades;


public class Planeta {

	private int id;
	private String nombre;
	private int coordenadaX;
	private int coordenadaY;
	private boolean estado;
	
	
	public int getId() {
		return id;
	}
	public void setId(int idPlaneta) {
		this.id = idPlaneta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombrePlaneta) {
		this.nombre = nombrePlaneta;
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
	
	public Planeta() {		
	}
	
	public Planeta(String nombre, int coordX, int coordY)
	{
		this.nombre=nombre;
		this.coordenadaX=coordX;
		this.coordenadaY=coordY;
	}
	
}