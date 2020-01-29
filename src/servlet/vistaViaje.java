package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Viaje;
import logic.ViajeController;

/**
 * Servlet implementation class vistaViaje
 */
@WebServlet("/vistaViaje")
public class vistaViaje extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public vistaViaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ViajeController vc=new ViajeController();
		try{ArrayList<Viaje> arribos=vc.getArribos(Integer.parseInt(request.getParameter("origen")),Integer.parseInt(request.getParameter("destino")));
		request.setAttribute("arribos", arribos);
		RequestDispatcher rd=request.getRequestDispatcher("Viaje/tabla.jsp");
		rd.forward(request,response);		
		}catch(Exception e) {
			ArrayList<Viaje> arribos=vc.getArribos(Integer.parseInt(request.getParameter("origen")),0);
			request.setAttribute("arribos", arribos);
			RequestDispatcher rd=request.getRequestDispatcher("Viaje/tabla.jsp");
			rd.forward(request,response);				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
