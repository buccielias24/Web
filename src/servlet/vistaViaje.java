package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

import entidades.Viaje;
import logic.ViajeController;

/**
 * Servlet implementation class vistaViaje
 */

@WebServlet("/vistaViaje")
public class vistaViaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ViajeController vc=new ViajeController();

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
		String origen=request.getParameter("from");
		String destino=request.getParameter("to");
		
		List<Viaje> lista=new ArrayList<Viaje>();
		lista=vc.getArribos(origen, destino);
		
		response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        Gson gson = new Gson();
        String jsonData = gson.toJson(lista);
        PrintWriter out = response.getWriter();
        try {
        	out.println(jsonData);           
        } finally {
            out.close();
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
