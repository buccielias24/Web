package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Planeta;
import entidades.Viaje;
import logic.PlanetaControler;
import logic.ViajeControler;
import entidades.Astrobus;
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
		int origen=Integer.parseInt(request.getParameter("origen"));
		int destino=Integer.parseInt(request.getParameter("destino"));
		String fechaS=request.getParameter("fechaSalida");
		String fechaL=request.getParameter("fechaLlegada");
		int astro = Integer.parseInt(request.getParameter("IdNave"));//Integer.parseInt(request.getParameter("Astrobus"));
		double dist=0;
		double distViaje = 0;//distancia entre planeta origen y planeta destino
		
		Planeta p1=new Planeta();
		Planeta p2=new Planeta();
		PlanetaControler pc=new PlanetaControler();
		p1.setIdPlaneta(origen);
		p2.setIdPlaneta(destino);
		p1=pc.getById(p1);
		p2=pc.getById(p2);
		distViaje= 5; //tenemos que asignar una formula vectorial para calcular la distancia entre planetas;
		
		
		Astrobus a=new Astrobus();
		AstrobusController AC=new AstrobusController();
		a.setIdNave(astro);
		a=AC.getById(a);
		dist=a.getDistRecorrida();// se asigna el kilometraje actual de la nave
		dist+=distViaje;//se suma el kilometraje actual de la nave y la distancia que ira a recorrer.
		
		Viaje v=new Viaje();
		v.setOrigen(p1);
		v.setDestino(p2);
		v.setSalida(fechaS);
		v.setLlegada(fechaL);
		v.setAstrobus(a);		
		
		
		ViajeControler vc=new ViajeControler();
		vc.add(v);
		
		
//https://programandoointentandolo.com/2014/09/ejecutar-metodo-a-hora-especifica-java.html
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
