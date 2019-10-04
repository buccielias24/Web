package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Astrobus;
import logic.AstrobusController;

/**
 * Servlet implementation class CargaAstrobus
 */
@WebServlet("/CargaAstrobus")
public class CargaAstrobus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaAstrobus() {
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
		Astrobus a=new Astrobus();
		
		a.setCantAsientos(Integer.parseInt(request.getParameter("cantAsientos")));
		a.setDistLimite(Float.parseFloat(request.getParameter("distLimite")));
		a.setDistService(Float.parseFloat(request.getParameter("distService")));
		
		a.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
		
		AstrobusController ac=new AstrobusController();
		ac.add(a);
		response.sendRedirect("registrarAstrobus.jsp");
		
		
		//doGet(request, response);
	}

}

