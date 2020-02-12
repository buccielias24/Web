package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Ciudadano;
import entidades.Planeta;
import entidades.Resenia;
import logic.PlanetaControler;
import logic.reseniaController;


/**
 * Servlet implementation class resenia
 */
@WebServlet("/resenia")
public class resenia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resenia() {
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
		reseniaController rc=new reseniaController();
		ArrayList<Resenia> resenias=rc.getAll(p);
		request.setAttribute("resenias", resenias);
		request.setAttribute("planeta", p);
		RequestDispatcher rd=request.getRequestDispatcher("Planeta/NewFile.jsp");
		rd.forward(request,response);				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		HttpSession session=request.getSession(false);
		Resenia r=new Resenia();
		Planeta p=new Planeta();
		p.setIdPlaneta(Integer.parseInt(request.getParameter("planeta")));
		PlanetaControler pc=new PlanetaControler();
		p=pc.getById(p);
		r.setPlaneta(p);
		r.setComentario(request.getParameter("comment"));
		r.setPuntaje(Integer.parseInt(request.getParameter("rate")));
		reseniaController rc=new reseniaController();
		r.setUsuario((Ciudadano)session.getAttribute("user"));
		rc.add(r);
		
	}	
}
