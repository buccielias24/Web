package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Ciudadano;
import entidades.Raza;
import logic.UserController;

/**
 * Servlet implementation class registroUsuario
 */
@WebServlet({"/registroUsuario","/registrousuario"})
public class registroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registroUsuario() {
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
		//doGet(request, response);
		UserController uc=new UserController();
		String fn=request.getParameter("firstName");
		String ln=request.getParameter("lastName");
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		String pass2=request.getParameter("password2");
		String email=request.getParameter("email");
		int dgu=Integer.parseInt(request.getParameter("DGU"));
		Ciudadano c=new Ciudadano(dgu,fn,ln,user,pass,email);	
		uc.addUser(c,pass2);	
	}

}
