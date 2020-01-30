package servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import entidades.Ciudadano;
import logic.UserController;

/**
 * Servlet Filter implementation class RoleFilter
 */
@WebFilter({"/Planeta/registrarPlaneta.jsp","/cargaviaje","/CargaViaje","/Planeta/modificarPlaneta.jsp","/Planeta/BajaPlaneta.jsp","/Viaje/registrarViaje.jsp"})
public class RoleFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RoleFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req=(HttpServletRequest) request;
		HttpSession session=req.getSession();
		HttpServletResponse resp=(HttpServletResponse) response;
		
		if(session.getAttribute("user")!=null)
		{
			Ciudadano c=(Ciudadano)session.getAttribute("user");
			System.out.println("usuario logeado"+c.getUser());
				if(c.getRol()==1)
					{
						chain.doFilter(request, response);
						System.out.println("usuario con permisos");
					}else 
					{
						System.out.println("usuario sin permisos");
						resp.sendRedirect("/Web/index.jsp");
					}
		} else
		{
			resp.sendRedirect("/Web/index.jsp");
			System.out.println("usuario no logeado");			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
