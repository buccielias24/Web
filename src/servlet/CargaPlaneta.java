package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataPlaneta;
import entidades.*;
import logic.*;

/**
 * Servlet implementation class Signin
 */
@WebServlet({ "/Cargaplaneta", "/cargaPlaneta", "/cargaPlaneta", "/CargaPlaneta", "/CARGAPLANETA" })
public class CargaPlaneta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CargaPlaneta() {
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
        Planeta planeta=new Planeta();
		PlanetaControler plaCtrl= new PlanetaControler();
		String id=request.getParameter("idPlaneta");
        String nombrePlaneta=request.getParameter("nombrePlanta");
        String coordenada=request.getParameter("coordenada");
        String estadoPlaneta=request.getParameter("estadoPlaneta");
        System.out.println(id+"|"+nombrePlaneta+"|"+coordenada+"|"+estadoPlaneta);
        
        Planeta p = new Planeta();
        p.setIdPlaneta(Integer.parseInt(id));
        p.setNombrePlaneta(nombrePlaneta);
        p.setCoordenada(coordenada);
        p.setEstado(Boolean.parseBoolean(estadoPlaneta));
        DataPlaneta dp=new DataPlaneta();
        dp.add(p);
       
       // p = planeta.validate(p);
       /* 
        request.getSession().setAttribute("usuario", p);
        request.getSession().setAttribute("listaPersonas", perCtrl.getAll());
        System.out.println(p);
        request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request, response);
        */
	}

}