package logic;

import data.DataViaje;
import entidades.Viaje;

public class ViajeControler {
	DataViaje dv;

	public ViajeControler() {
		dv=new DataViaje();
	}
	
	public void add(Viaje v)
	{
		dv.add(v);	
	}
	
	
}
