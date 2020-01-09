package logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import data.DataViaje;
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
			if (v.getAstrobus().getDistService()<=v.getDistancia())
					{
					 LocalDateTime localDate=LocalDateTime.now();
					 DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");					 
					 AstrobusController ac=new AstrobusController();
					 v.getAstrobus().setEstado(false);
					 v.getAstrobus().setFecha_baja(localDate.format(formatter));
					 v.getAstrobus().setMotivo(3);
					 v.getAstrobus().setComentario("En service");
					 ac.modify(v.getAstrobus());
					}
			else { 
		dv.add(v);
			}	
	}
	

	public ArrayList<Viaje> getAll(){
		return dv.getAll();
	}
	
	public void modify(Viaje v)
	{
		dv.modify(v);
	}
	
}
