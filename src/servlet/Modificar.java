package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Planeta;
import logic.PlanetaControler;

/**
 * Servlet implementation class Modificar
 */
@WebServlet({"/Modificar","/modificar"})
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modificar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Planeta p=new Planeta();
		p.setIdPlaneta(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("planeta", p);
		RequestDispatcher rd=request.getRequestDispatcher("Planeta/modificarPlaneta.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String nombre=request.getParameter("nombre");		
		int coordX=Integer.parseInt(request.getParameter("coordenadaX"));
		int coordY=Integer.parseInt(request.getParameter("coordenadaY"));
		boolean estado=Boolean.parseBoolean(request.getParameter("estado"));
		PlanetaControler pc=new PlanetaControler();

		Planeta p=new Planeta();

		p.setIdPlaneta(id);
		p.setNombrePlaneta(nombre);
		p.setCoordenadaX(coordX);
		p.setCoordenadaY(coordY);
		p.setEstado(estado);
		pc.modify(p);
	}

}