
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import entidades.*;
import logic.*;

/**
 * Servlet implementation class Planetas
 */
@WebServlet({"/Planetas","/planetas"})
@MultipartConfig
public class Planetas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlanetaControler pc=new PlanetaControler();

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
		
		
		HttpSession session=request.getSession(false);  
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        Gson gson = new Gson();
        List<Planeta> planetas=pc.getAll();
        
      
        Ciudadano c = ((Ciudadano)session.getAttribute("user"));
        
        ArrayList<Object> objetos=new ArrayList<Object>();
        objetos.addAll(planetas);
        objetos.add(c);
        
        String json= gson.toJson(objetos);
      
        
        
        PrintWriter out = response.getWriter();
        try {
        	out.println(json);

        } finally {
            out.close();
          
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		    String accion=request.getParameter("accion");
		    HttpSession session=request.getSession(false);
		    
		    if (accion.equalsIgnoreCase("new"))
		        {
		    	String nombre=request.getParameter("nombreP");
		    	int coordenadaX=Integer.parseInt(request.getParameter("coordX"));
		    	int coordenadaY=Integer.parseInt(request.getParameter("coordY"));
		    	Planeta p=new Planeta(nombre,coordenadaX,coordenadaY);
			
			  			
		    	pc.add(p,(Ciudadano)session.getAttribute("user"));
		    	List<Planeta> planetas=pc.getAll();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				Gson gson = new Gson();
				String jsonData = gson.toJson(planetas);
				PrintWriter out = response.getWriter();
				try {
		        		out.println(jsonData);
					} finally {
						out.close();}
		        }else if(accion.equalsIgnoreCase("edit"))
		        {
		    	int id=Integer.parseInt(request.getParameter("id"));
				String nombre=request.getParameter("nombre");		
				int coordX=Integer.parseInt(request.getParameter("coordenadaX"));
				int coordY=Integer.parseInt(request.getParameter("coordenadaY"));
				boolean estado=Boolean.parseBoolean(request.getParameter("estado"));
				

				Planeta p=new Planeta();
				p.setId(id);
				p.setNombre(nombre);
				p.setCoordenadaX(coordX);
				p.setCoordenadaY(coordY);
				p.setEstado(estado);				
				pc.modify(p);
				List<Planeta> planetas=pc.getAll();
				response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        Gson gson = new Gson();
		        String jsonData = gson.toJson(planetas);
		        PrintWriter out = response.getWriter();
			    try {
			        	out.println(jsonData);
			        } finally {
			            out.close();
			          
			        }	
		    	
		        }else if(accion.equalsIgnoreCase("delete"))
		        {
		        	System.out.println("eliminar");
		   
		        }
	}
}


