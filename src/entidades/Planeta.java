package entidades;

import java.util.Scanner;

public class Planeta {

	private int idPlaneta;
	private String nombrePlaneta;
	private String coordenada;
	private boolean estado;
	
	public Planeta() {}
	
	public Planeta(int idPlaneta, String nombrePlaneta, String coordenada, boolean estado) {
		super();
		this.idPlaneta = idPlaneta;
		this.nombrePlaneta = nombrePlaneta;
		this.coordenada = coordenada;
		this.estado = estado;
	}
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
	public String getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(String coordenada) {
		this.coordenada = coordenada;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void cargaDatos() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Ingrese ID del planeta");
		this.setIdPlaneta(Integer.parseInt(scan.nextLine()));
		System.out.println("Ingrese nombre del planeta");
		this.setNombrePlaneta(scan.nextLine());
		System.out.println("Ingrese coordenada del planeta");
		this.setCoordenada(scan.nextLine());
		System.out.println("Ingrese estado del planeta");
		this.setEstado(scan.hasNextBoolean());
		scan.close();
	}
	
	@Override
	public String toString() {
		return
				"\nId Planeta: "+this.getIdPlaneta()+
				"\tNombre Planeta: "+this.getNombrePlaneta()+
				"\tCoordenada: "+this.getCoordenada()+
				"\tEstado: "+this.getEstado();
	}

	
		
}
