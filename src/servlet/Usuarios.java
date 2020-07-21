package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.*;
import logic.UserController;
/**
 * Servlet implementation class UsuarioEdit
 */
@WebServlet({"/Usuarios","/usuarios"})
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UserController uc=new UserController();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
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
		String action=request.getParameter("action");
		if (action.equalsIgnoreCase("nuevo"))
			{
			  if(request.getParameter("password").equals(request.getParameter("password2"))){
				 Ciudadano c=new Ciudadano();
				 c.setApellido(request.getParameter("apellido"));
				 c.setNombre(request.getParameter("nombre"));
				 c.setDgu(Integer.parseInt(request.getParameter("dgu")));
				 c.setEmail(request.getParameter("email"));
				 c.setPassword(request.getParameter("password"));
				 c.setUser(request.getParameter("usuario"));
				 uc.addUser(c);} 
			  else {
				  
			  	   
			       }
		   }
	}

}
