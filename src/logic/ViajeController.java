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
}
