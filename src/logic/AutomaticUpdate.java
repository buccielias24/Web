package logic;


import static java.util.concurrent.TimeUnit.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import entidades.Viaje;

public class AutomaticUpdate {
   private final ScheduledExecutorService scheduler = 
      Executors.newScheduledThreadPool(1);
   ViajeController vc=new ViajeController();
	
   public void beepForAnHour() {
       final Runnable beeper = new Runnable() {
               public void run() 
               {
            	   actualizarEstados();
            	   System.out.println("Viajes Actualizados");
            	   
               }
           };
       final ScheduledFuture<?> beeperHandle = 
           scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
       scheduler.schedule(new Runnable() {
               public void run() { beeperHandle.cancel(true); }
           }, 60 * 60, SECONDS);
   }
   
   public void actualizarEstados()
	{
		LocalDateTime localDate=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		ArrayList<Viaje> viajes=vc.getAll();
			for(Viaje v:viajes)
			{
				if(v.getLlegada().compareTo(localDate.format(formatter))<=0 && v.getEstado()!=4)
				{					
					v.setEstado(4);
					vc.modify(v);
					System.out.println("Viaje actualizado");
				}else {
					System.out.println("Viaje no actualizado");
				}
			}
	}
}

