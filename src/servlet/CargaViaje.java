package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Planeta;
import entidades.Viaje;
import logic.PlanetaControler;
import logic.ViajeControler;

/**
 * Servlet implementation class CargaViaje
 */
@WebServlet("/CargaViaje")
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
		
		Planeta p1=new Planeta();
		Planeta p2=new Planeta();
		PlanetaControler pc=new PlanetaControler();
		p1.setIdPlaneta(origen);
		p2.setIdPlaneta(destino);
		p1=pc.getById(p1);
		p2=pc.getById(p2);
		
		Viaje v=new Viaje();
		v.setOrigen(p1);
		v.setDestino(p2);
		v.setSalida(fechaS);
		v.setLlegada(fechaL);
		
		ViajeControler vc=new ViajeControler();
		vc.add(v);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
