package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.util.DraconianErrorHandler;

import entidades.Ciudadano;
import entidades.Planeta;
import logic.UserController;
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
	
		if(request.getParameter("accion").equals("new"))
		{
			try {
			HttpSession session=request.getSession(false);  
				reseniaController rc=new reseniaController();
					switch(rc.existResenia((Ciudadano)session.getAttribute("user"), p))
					{
					case 1:{
							
					}break;
					case 2:{
						System.out.println("caso 2");
					}break;
					case 3:{
						RequestDispatcher rd=request.getRequestDispatcher("/nologged.jsp");
						rd.forward(request, response);
					}break;
			 	/*	RequestDispatcher rd=request.getRequestDispatcher("/Planeta/BajaPlaneta.jsp");
			 		rd.forward(request, response);*/
					}
			}
			catch(Exception e) {
				RequestDispatcher rd=request.getRequestDispatcher("/nologged.jsp");
				rd.forward(request, response);
			}
		}else
		{			
		request.setAttribute("planeta", p);		
		RequestDispatcher rd=request.getRequestDispatcher("Planeta/vistaResenia.jsp");
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
