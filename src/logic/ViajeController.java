package logic;

import java.util.ArrayList;

import data.DataViaje;
import entidades.Planeta;
import entidades.Viaje;

public class ViajeController {
	DataViaje dv;

	public ViajeController() {
		dv=new DataViaje();
	}
	
	public void add(Viaje v)
	{	
		double x=v.getDestino().getCoordenadaX()-v.getOrigen().getCoordenadaX();	
		double y=v.getDestino().getCoordenadaY()-v.getOrigen().getCoordenadaY();
		v.setDistancia(Math.sqrt(x*x+y*y));
		System.out.println(v.getDistancia());
		dv.add(v);	
	}
	
	public ArrayList<Viaje> getAll(){
		return dv.getAll();
	}
	
	
}
