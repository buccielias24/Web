package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Planeta;
import entidades.Viaje;
import logic.PlanetaControler;
import logic.ViajeController;
import entidades.Astrobus;
import entidades.Ciudadano;
import logic.AstrobusController;
/**
 * Servlet implementation class CargaViaje
 */
@WebServlet({"/CargaViaje","/cargaviaje"})
public class CargaViaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaViaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		
		int origen=Integer.parseInt(request.getParameter("origen"));
		int destino=Integer.parseInt(request.getParameter("destino"));
		String horaS=request.getParameter("horaSalida");
		int astro= Integer.parseInt(request.getParameter("elegirAstrobus"));
	    boolean frecuencia[]=new boolean[7];
	    frecuencia[0]=Boolean.parseBoolean(request.getParameter("Lunes"));
	    frecuencia[1]=Boolean.parseBoolean(request.getParameter("Martes"));
	    frecuencia[2]=Boolean.parseBoolean(request.getParameter("Miercoles"));
	    frecuencia[3]=Boolean.parseBoolean(request.getParameter("Jueves"));
	    frecuencia[4]=Boolean.parseBoolean(request.getParameter("Viernes"));
	    frecuencia[5]=Boolean.parseBoolean(request.getParameter("Sabado"));
	    frecuencia[6]=Boolean.parseBoolean(request.getParameter("Domingo"));	    
	    String desde=request.getParameter("desde");
	    String hasta=request.getParameter("hasta");
	    
	    
	    Astrobus a=new Astrobus();
		Planeta p1=new Planeta();
		Planeta p2=new Planeta();
		
		AstrobusController ac=new AstrobusController();
		PlanetaControler pc=new PlanetaControler();
		ViajeController vc=new ViajeController();
		
		p1.setIdPlaneta(origen);
		p2.setIdPlaneta(destino);
		a.setIdNave(astro);
		
		p1=pc.getById(p1);
		p2=pc.getById(p2);
		a=ac.getById(a);
		
		Viaje v=new Viaje();
		v.setOrigen(p1);
		v.setDestino(p2);
        v.setAstrobus(a);		
        v.setFrecuencia(frecuencia);
        v.setDistancia(vc.getDistancia(v));

        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date[] fechas=vc.determinarFecha(desde, hasta, frecuencia, horaS);
		for(int i=0; i<fechas.length ;i++)	
		{		
			v.setSalida(formatter.format(fechas[i]));
			Date newDate=new Date(fechas[i].getTime()+TimeUnit.HOURS.toMillis(Math.round(v.getDistancia()/100)));
			v.setLlegada(formatter.format(newDate));
			System.out.println("salida: "+fechas[i]+" llegada : "+newDate);
			vc.add(v,(Ciudadano)session.getAttribute("user"));
		   
		} 
		
	}

	/**
	 * @|see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
