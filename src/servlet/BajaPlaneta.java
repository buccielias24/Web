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
 * Servlet implementation class ModificarPlaneta
 */
@WebServlet("/BajaPlaneta")
public class BajaPlaneta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaPlaneta() {
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
		RequestDispatcher rd=request.getRequestDispatcher("Planeta/BajaPlaneta.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlanetaControler pc=new PlanetaControler();
		
		Planeta p= new Planeta();
		int id=Integer.parseInt(request.getParameter("idPlaneta"));
		int motivoBaja=Integer.parseInt(request.getParameter("motivoBaja"));
		p.setIdPlaneta(id);
		p.setMotivo(motivoBaja);
		pc.baja(p);
		response.sendRedirect("/Web/Planeta/vistaPrincipal.jsp");
		}
}
