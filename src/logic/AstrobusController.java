package logic;

import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.impl.dv.DVFactoryException;

import data.DataAstrobus;
import data.DataViaje;
import entidades.Astrobus;
import entidades.Viaje;


public class AstrobusController {

	DataAstrobus da;
	
	public AstrobusController() {
		da=new DataAstrobus();
	}
	
	public ArrayList<Astrobus> getAll(){
		return da.getAll();
	}
	
	public void add(Astrobus a) {
		da.add(a); 
	}
	public Astrobus getById(Astrobus a) {
		return da.getById(a);
		
	}
	
	public void modify(Astrobus a)
	{
		da.modify(a);
	}
	public double getDistancia(Astrobus a)

	{
			double total=0;
				ArrayList<Viaje> viajes=new ViajeController().getAll();
					for(Viaje v:viajes)
					{
							if(v.getAstrobus().getIdNave()==a.getIdNave())
							{
								total=total+v.getDistancia();
							}
					}
		return total;
	}		

}
