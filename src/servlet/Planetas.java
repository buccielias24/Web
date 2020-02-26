
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Ciudadano;
import entidades.Planeta;
import logic.PlanetaControler;

/**
 * Servlet implementation class Planetas
 */
@WebServlet({"/Planetas","/planetas"})
@MultipartConfig
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
		    
			PlanetaControler pc=new PlanetaControler();
			
			String nombre=request.getParameter("inAlta1");
			int coordenadaX=Integer.parseInt(request.getParameter("inAlta2"));
			int coordenadaY=Integer.parseInt(request.getParameter("inAlta3"));
			Planeta p=new Planeta(nombre,coordenadaX,coordenadaY);
			
			HttpSession session=request.getSession(false);  			
			int resp=pc.add(p,(Ciudadano)session.getAttribute("user"));
			if(resp==0)
			{
			RequestDispatcher rd=request.getRequestDispatcher("/Planeta/exito.jsp");
			rd.forward(request,response);
			}else {
				request.setAttribute("code", resp);
				RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
				rd.forward(request,response);			
			}
	}
	
}
