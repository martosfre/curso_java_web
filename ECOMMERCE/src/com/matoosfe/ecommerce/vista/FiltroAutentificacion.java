package com.matoosfe.ecommerce.vista;

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

/**
 * Servlet Filter implementation class FiltroAutentificacion
 */
@WebFilter(description = "Filtro para verificar credenciales del usuario, que este logeado", urlPatterns = {
		"/pages/*" })
public class FiltroAutentificacion implements Filter {

	/**
	 * Default constructor.
	 */
	public FiltroAutentificacion() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Verificar usuario en sesion
		HttpServletRequest reqHttp = (HttpServletRequest) request;
		HttpSession sesion = reqHttp.getSession();
		//Usuario si se logeo
		if (sesion.getAttribute("usuario") != null) {
			chain.doFilter(request, response);// Transfiere al recurso
		} else {
			/*En filtros siempre utilizar este código para redireccionar, porque el filtro no se llama 
			 * y no pasa por el protocolo HTTP
			 */
			HttpServletResponse responseHttp = (HttpServletResponse) response;
			responseHttp.sendRedirect("/ECOMMERCE/login.html");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
