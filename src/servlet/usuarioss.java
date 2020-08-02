package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import entidades.Ciudadano;
import logic.UserController;

/**
 * Servlet implementation class usuarioss
 */
@WebServlet("/usuarioss")
public class usuarioss extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final UserController uc=new UserController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usuarioss() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email="asd@asd.com";
		String emailresponse = null;
		try {
			emailresponse=uc.checkEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonObject jo=new JsonObject();
		JsonObject jo2=new JsonObject();
		Gson g = new Gson(); 
		jo = g.fromJson(emailresponse, JsonObject.class);
		jo2.addProperty("estadoemail", jo.get("smtp_check").toString());
		jo2.addProperty("error", "usuario_mail");
			PrintWriter out =response.getWriter();  
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.println(jo2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject jo=new JsonObject(); 
        jo.addProperty("error", "success");
		PrintWriter out =response.getWriter();  
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(jo);
        
	}

}
