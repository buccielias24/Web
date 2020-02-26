package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Astrobus;
import logic.AstrobusController;

/**
 * Servlet implementation class ModificarPlaneta
 */
@WebServlet("/BajaAstrobus")
public class BajaAstrobus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaAstrobus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Astrobus a=new Astrobus();
		a.setIdNave(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("astrobus", a);
		RequestDispatcher rd=request.getRequestDispatcher("Astrobus/BajaAstrobus.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AstrobusController ac=new AstrobusController();
		
		Astrobus a= new Astrobus();
		int id=Integer.parseInt(request.getParameter("inBaja1"));
		//String motivo=request.getParameter(parseInt("inBaja3"));
		
		a.setIdNave(id);
		a=ac.getById(a);
		//a.setMotivo(motivo);		
		ac.modify(a);
		response.sendRedirect("/Web/Astrobus/vistaPrincipal.jsp");
		}
}
