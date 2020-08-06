
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.google.gson.JsonObject;

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
	private reseniaController rc=new reseniaController();
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
		try {
		if(request.getParameter("accion").equalsIgnoreCase("vista")) {
		Ciudadano c=new Ciudadano();
        try {
            c = ((Ciudadano)session.getAttribute("user"));
            }catch(Exception e) {
            c=null;	
            }      
        
        List<Planeta> planetas=pc.getAll();
        List<Resenia> resenias=rc.getAll();
        
        Gson gson = new Gson();
        JsonArray ja=new JsonArray();    
        
        String usuario= gson.toJson(c);
        
        for(Planeta p:planetas)
        		{
        	     JsonArray reseniasP=new JsonArray();
        		 JsonObject jo=new JsonObject(); 
        		 jo.addProperty("id_planeta", p.getId());
        		 jo.addProperty("nombre", p.getNombre());
        		 jo.addProperty("coordenadaX", p.getCoordenadaX());
        		 jo.addProperty("coordenadaY", p.getCoordenadaY());
        		 jo.addProperty("estado", p.getEstado());
        		 jo.addProperty("url", p.getUrl());
        		 float puntaje=0;
        		 int contador=0;
        		 for(Resenia r:resenias) {
        			  if (r.getPlaneta().getId()==p.getId())
        			  {  
        				 JsonObject resenia=new JsonObject(); 
        				 resenia.addProperty("apelnom", r.getUsuario().getNombre().concat(", ").concat(r.getUsuario().getApellido())); 
        				 resenia.addProperty("puntaje", r.getPuntaje());
        				 resenia.addProperty("fecha", r.getFecha().toString());
        				 resenia.addProperty("comentario", r.getComentario());
        				 reseniasP.add(resenia);
        				 puntaje=puntaje+r.getPuntaje();
        				 contador++;
        			  }	  
        		  	}
        		 jo.add("resenias",reseniasP);
        		 if(contador!=0)
        		 {
        		 jo.addProperty("puntaje", puntaje/contador);
        		 }else {jo.addProperty("puntaje", 0);}
        		 ja.add(jo); 
        		}
        
        ja.add(usuario);
        
        
        PrintWriter out =response.getWriter();  
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(ja); 
		}
		}catch(Exception e) {
		RequestDispatcher rd=request.getRequestDispatcher("/NewFile3.jsp");
		rd.forward(request,response);}
        
 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		    String accion=request.getParameter("accion");
		    HttpSession session=request.getSession(false);
		    Ciudadano c=(Ciudadano)session.getAttribute("user");
		    if (accion.equalsIgnoreCase("new"))
		        {
		    	String nombre=request.getParameter("nombreP");
		    	int coordenadaX=Integer.parseInt(request.getParameter("coordX"));
		    	int coordenadaY=Integer.parseInt(request.getParameter("coordY"));
		    	Planeta p=new Planeta(nombre,coordenadaX,coordenadaY);		
		    	pc.add(p,c);
		    	doGet(request, response);
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
				  
				  doGet(request, response);			    	
		        }else if(accion.equalsIgnoreCase("delete"))
		        {
		        	System.out.println("eliminar");
		   
		        }
	}
}


