package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import data.DataViaje;
import entidades.Ciudadano;
import entidades.Planeta;
import entidades.Viaje;

public class ViajeController {
	DataViaje dv; 

	public ViajeController() {
		dv=new DataViaje();
	}
	
	
	public boolean add(Viaje v, Ciudadano user)
	{		
		if(user==null || user.getRol()!=1)
		{
		return false;
		}else
		{
			v.setDistancia(this.getDistancia(v));
			dv.add(v);				
			return true;
		}
	}			

	public ArrayList<Viaje> getAll(){
		return dv.getAll();
	}
	
	// agregar metodo para determinar dia y hora de llegada a traves de un calculo
	
	public ArrayList<Viaje> getArribos(int origen, int destino){
		ArrayList<Viaje> viajes=this.getAll();
		ArrayList<Viaje> arribos=new ArrayList<Viaje>(); 
		PlanetaControler pc=new PlanetaControler();
		Planeta p1=new Planeta();
		Planeta p2=new Planeta();
		if(destino==0)
		{
			p2=null;
		}else {p2.setIdPlaneta(destino);
		p2=pc.getById(p2);}
		
		p1.setIdPlaneta(origen);
		p1=pc.getById(p1);
			if(p2==null)
			{
				for(Viaje v:viajes) {
					if(v.getOrigen().equals(p1))
					{
						arribos.add(v);
					}
				}
			}else {
				for(Viaje v:viajes) {
					if(v.getOrigen().equals(p1)&&v.getDestino().equals(p2))
					{
						arribos.add(v);
					}
				}
			}
			return arribos;
		}
	
	public Date[] determinarFecha(String desde, String hasta, boolean[] frecuencia, String horaS) {
		
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		//String fechaActual = formatter.format(new Date());
		List<Date>dates=new ArrayList<Date>();
		Calendar cini=Calendar.getInstance();
		Calendar cfin=Calendar.getInstance();

		try {
			
			cini.setTime(formatter.parse(desde.concat(" ").concat(horaS)));
			cfin.setTime(formatter.parse(hasta.concat(" ").concat("23:59")));
			System.out.println("fecha salida: "+cini);
			System.out.println("fecha llegada "+cfin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!cfin.before(cini)) {
		if(cini.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY && frecuencia[0]==true) {
				dates.add(cini.getTime());
			}else			
			if(cini.get(Calendar.DAY_OF_WEEK)==Calendar.TUESDAY && frecuencia[1]==true) {
				dates.add((cini.getTime()));
			}else
				if(cini.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY && frecuencia[2]==true) {
					dates.add((cini.getTime()));}else
						if(cini.get(Calendar.DAY_OF_WEEK)==Calendar.THURSDAY && frecuencia[3]==true) {
							dates.add((cini.getTime()));}else
								if(cini.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY && frecuencia[4]==true) {
									dates.add((cini.getTime()));}else
										if(cini.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY && frecuencia[5]==true) {
											dates.add((cini.getTime()));}else
												if(cini.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY && frecuencia[6]==true) {
													dates.add((cini.getTime()));}
			
			cini.add(Calendar.DATE,1);
		}
		System.out.println("a ver :"+dates.size());
		Date[] arreglo=new Date[dates.size()];
		return (dates.toArray(arreglo));
	} 

	public double getDistancia(Viaje v) {
		double total=0;
		total=Math.sqrt(Math.pow(v.getDestino().getCoordenadaX()-v.getOrigen().getCoordenadaX(), 2)+Math.pow(v.getDestino().getCoordenadaY()-v.getOrigen().getCoordenadaY(), 2));		
		return total;
	}
	
	
	public void modify(Viaje v)
	{
		dv.modify(v);
	}
	
}
