package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import entidades.Ciudadano;
import logic.AutomaticUpdate;
import logic.UserController;

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
		//uc.correo();
		Ciudadano ciud=new Ciudadano();
		ciud.setUser(request.getParameter("user"));
		ciud.setPassword(request.getParameter("password"));
		//AutomaticUpdate au=new AutomaticUpdate();
		//au.beepForAnHour();
		
		if (uc.userExist(ciud))		
		{
			HttpSession misession= request.getSession();
			misession.setAttribute("user",uc.getById(ciud));
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request,response);
		}
		else {
		    RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		    rd.forward(request,response);
		
	  }
		}
	
	

}
