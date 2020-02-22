package logic;


import static java.util.concurrent.TimeUnit.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import entidades.Astrobus;
import entidades.Viaje;

public class AutomaticUpdate {
 /*  private final ScheduledExecutorService scheduler = 
      Executors.newScheduledThreadPool(1);
   public void beepForAnHour() {
       final Runnable beeper = new Runnable() {
               public void run() 
               {
            	actualizarEstados();   
            	asignarAstrobus();
            	System.out.println("Actualizado");
               }
           };
       final ScheduledFuture<?> beeperHandle = 
           scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
       scheduler.schedule(new Runnable() {
               public void run() { beeperHandle.cancel(true); }
           }, 60 * 60, SECONDS);
   }
   
   

   public void actualizarAstrobus(Astrobus a) 
   {
	   AstrobusController ac=new AstrobusController();
	   a.setEstado(true);
	   SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	   String fechaActual = formatter.format(new Date());
	   a.setTiempoLibre(fechaActual);
	//Agregar distancia Recorrida al adicionar service
	   ac.modify(a);
	   
	   
   }
   
   public void actualizarEstados()
	{
	   ViajeController vc=new ViajeController();
		LocalDateTime localDate=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		ArrayList<Viaje> viajes=vc.getAll();
			for(Viaje v:viajes)
			{
				if(v.getLlegada().compareTo(localDate.format(formatter))<=0 && v.getEstado()!=4)
				{					
					v.setEstado(4);
					vc.modify(v);
				}else {
				}
			}
	}
	*/
}

