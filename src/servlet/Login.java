package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Ciudadano;
import logic.UserController;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class Login
 */
@WebServlet({"/Login","/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		UserController uc=new UserController();
		Ciudadano ciud=new Ciudadano();
		ciud.setUser(request.getParameter("user"));
		ciud.setPassword(request.getParameter("password"));
		if(uc.getById(ciud).getUser().equals(ciud.getUser())&&uc.getById(ciud).getPassword().equals(ciud.getPassword()))
		{	
			request.setAttribute("usuario",uc.getById(ciud).getApellido()+", "+uc.getById(ciud).getNombre() );
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request,response);
		}
	}

}
