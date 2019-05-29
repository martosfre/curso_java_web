package com.matoosfe.ecommerce.vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletMenu
 */
@WebServlet(description = "Servlet para generar el menu", urlPatterns = { "/bzx123" })
public class ServletMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.Recuperar el escritor
		PrintWriter escritor = response.getWriter();
		//2.Escribir contenido
		escritor.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>ECOMMERCE</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div align=\"center\">\r\n" + 
				"	<label>Usuario Conectado:" +  request.getSession().getAttribute("usuario") + "" + 
				"</div>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		escritor.print("Usuario Logeado:" + request.getSession().getAttribute("usuario"));
		//3.Cerrar el escritor
		escritor.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
