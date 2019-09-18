package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Planeta;
import logic.PlanetaControler;

/**
 * Servlet implementation class CargaPlaneta
 */
@WebServlet("/CargaPlaneta")
public class CargaPlaneta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaPlaneta() {
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
		Planeta p=new Planeta();
		p.setCoordenada(request.getParameter("coordenada"));
		p.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
		p.setNombrePlaneta(request.getParameter("nombre"));
		PlanetaControler pc=new PlanetaControler();
		pc.add(p);
		response.sendRedirect("registrarPlaneta.jsp");
	}
}
