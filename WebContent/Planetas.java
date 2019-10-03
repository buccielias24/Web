package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

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
			p.setCoordenada(request.getParameter("coordenada"));
			p.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
			p.setNombrePlaneta(request.getParameter("nombre"));
			PlanetaControler pc=new PlanetaControler();
			pc.add(p);	
		} break;
		case "modificar":{
			int id=Integer.parseInt(request.getParameter("id"));
			String nombre=request.getParameter("nombre");		
			String coordenada=request.getParameter("coordenada");
			Boolean estado=Boolean.parseBoolean(request.getParameter("estado"));
			PlanetaControler pc=new PlanetaControler();
			Planeta p=new Planeta();
			p.setIdPlaneta(id);
			p.setCoordenada(coordenada);
			p.setNombrePlaneta(nombre);
			p.setEstado(estado);
			pc.modify(p);
			RequestDispatcher rd=request.getRequestDispatcher("lista.jsp");
			rd.forward(request,response);
		}break;
		case "baja":{
			Planeta p= new Planeta();
			int id=Integer.parseInt(request.getParameter("id"));
			p.setIdPlaneta(id);
			//p=pc.getById(id);
			PlanetaControler pc=new PlanetaControler();
			pc.delete(p);
		}break;			
		}
		response.sendRedirect("home.jsp");
	}
	
}
