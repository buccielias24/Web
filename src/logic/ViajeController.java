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
		dv.add(v);	
	}
	
	public ArrayList<Viaje> getAll(){
		return dv.getAll();
	}
	public double getDistancia(Viaje vi) {
		double dr=0;
		int x1=vi.getDestino().getCoordenadaX();
		int y1=vi.getDestino().getCoordenadaY();
		int x2=vi.getOrigen().getCoordenadaX();
		int y2=vi.getOrigen().getCoordenadaY();
		int x= x1-x2;
		int y= y1-y2;
		x=x*x;
		y=y*y;
		int xy=x+y;
		dr=Math.sqrt(xy);
		return dr;
	}
	
}
