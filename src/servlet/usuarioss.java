package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class usuarioss
 */
@WebServlet("/usuarioss")
public class usuarioss extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		JsonObject jo=new JsonObject(); 
        jo.addProperty("error", "success");
		PrintWriter out =response.getWriter();  
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(jo);
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
