package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.Out;

import entidades.Ciudadano;
import entidades.Planeta;
import logic.PlanetaControler;

/**
 * Servlet implementation class Planetas
 */
@WebServlet({"/Planetas","/planetas"})
public class Planetas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Planetas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String opc=request.getParameter("accion");
		switch(opc)
		{
		case "alta": 
		{
			Planeta p=new Planeta();
			p.setNombrePlaneta(request.getParameter("inAlta1"));			
			p.setCoordenada(request.getParameter("inAlta2"));
			p.setFecha_alta(request.getParameter("inAlta3"));
			
			HttpSession session=request.getSession(false);  
			
			PlanetaControler pc=new PlanetaControler();
			pc.add(p,(Ciudadano)session.getAttribute("user"));
			Ciudadano c=(Ciudadano)session.getAttribute("user");
			System.out.println(c);
		} break;
					
		}
	}
	
}
