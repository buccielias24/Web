package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
		List<Ciudadano> usuarios=uc.getAll();
        
        JsonArray ja=new JsonArray();    
        
        for(Ciudadano usuario:usuarios)
        		{
        		 JsonObject jo=new JsonObject(); 
        		 jo.addProperty("dgu", usuario.getDgu());
        		 jo.addProperty("nombre", usuario.getNombre());
        		 jo.addProperty("apellido", usuario.getApellido());
        		 jo.addProperty("usuario", usuario.getUser());
        		 jo.addProperty("email",usuario.getEmail());
        		 jo.addProperty("rol", usuario.getRol());
      
        		 ja.add(jo); 
        		}       
        PrintWriter out =response.getWriter();  
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(ja);   
   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String email=request.getParameter("email");
			String emailresponse=null;
			try {
				emailresponse=uc.checkEmail(email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JsonObject correo=new JsonObject();
			
			Gson g = new Gson(); 
			correo = g.fromJson(emailresponse, JsonObject.class);
			
			
			JsonObject jo=new JsonObject();
			
			
				for(Ciudadano usuario:uc.getAll())
				{
					if(usuario.getEmail().equalsIgnoreCase(email))
					{
						 
				        jo.addProperty("error", "usuario_mail");
					}
					else jo.addProperty("error", "success");
				}
				jo.addProperty("estadoemail", correo.get("smtp_check").toString());
				PrintWriter out =response.getWriter();  
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        out.println(jo);
	}
}
