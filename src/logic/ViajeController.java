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
	
	
	public void add(Viaje v)
	{		
	 dv.add(v);
    }
	
	public ArrayList<Viaje> getAll(){
		return dv.getAll();
	}
	
	// agregar metodo para determinar dia y hora de llegada a traves de un calculo
	
	public ArrayList<Viaje> getArribos(int origen, int destino){
		
		ArrayList<Viaje> viajes=this.getAll();
		ArrayList<Viaje> arribos=new ArrayList<Viaje>(); 
	
			for(Viaje v:viajes) {
				if(v.getOrigen().getIdPlaneta()==origen && v.getDestino().getIdPlaneta()==destino)
					{
						arribos.add(v);
					}
		
				}
			
			return arribos;
		}
	
	public Date[] determinarFecha(String desde, String hasta, boolean[] frecuencia, String horaS) {
		
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String fechaActual = formatter.format(new Date());
		List<Date>dates=new ArrayList<Date>();
		Calendar cini=Calendar.getInstance();
		Calendar cfin=Calendar.getInstance();
		Calendar cactu=Calendar.getInstance();
		try {
			
			cini.setTime(formatter.parse(desde.concat(" ").concat(horaS)));
			cfin.setTime(formatter.parse(hasta.concat(" ").concat("23:59")));
			cactu.setTime(formatter.parse(fechaActual));
			System.out.println("fecha salida: "+cini);
			System.out.println("fecha llegada "+cfin);
			System.out.println("fecha actual "+cactu);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				if(cini.before(cactu))
					{
			 		System.out.println("No se pueden agregar viajes anteriores a la fecha actual");
					}else {
							if(cfin.get(cfin.YEAR)!=2020) 
			 					{System.out.println("FECHA INVALIDA");
			 					}else {
			 							System.out.println("FECHA VALIDA");
											while(!cfin.before(cini)) {
													if(cini.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY && frecuencia[0]==true) {
															dates.add(cini.getTime());}else			
													if(cini.get(Calendar.DAY_OF_WEEK)==Calendar.TUESDAY && frecuencia[1]==true) {
														    dates.add((cini.getTime()));}else
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
					}
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
	
	public ArrayList<Viaje> getViajesSinAstrobus(){
		
		ArrayList<Viaje> sinNave=new ArrayList<Viaje>();
			ArrayList<Viaje> viajes=this.getAll();
				for(Viaje v:viajes)
				{
					if(v.getAstrobus().getIdNave()==0 && this.calcularDiferencia(v.getSalida())<=20 && this.calcularDiferencia(v.getSalida())>=0)
					{
				    sinNave.add(v);
					}
			} 
		return sinNave;
	}
	
	public long calcularDiferencia(String inicio) {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String fechaActual = formatter.format(new Date());	
		Calendar cini=Calendar.getInstance();
		Calendar cfin=Calendar.getInstance();
		try {
			cini.setTime(formatter.parse(inicio));
			cfin.setTime(formatter.parse(fechaActual));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long diferencia=cini.getTimeInMillis()-cfin.getTimeInMillis();
		return diferencia/(1000*3600);
		
	}
	
}
