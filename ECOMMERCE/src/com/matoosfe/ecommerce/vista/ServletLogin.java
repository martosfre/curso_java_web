package com.matoosfe.ecommerce.vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.matoosfe.ecommerce.modelo.Usuario;
import com.matoosfe.ecommerce.negocio.UsuarioTrs;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(description = "Clase para procesar los valores ingresados en el formulario de login", urlPatterns = { "/abz345" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletLogin() {
        
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Recuperar datos enviados en un request (página web o una url dinámica)
		String nombreUsuario = request.getParameter("txtNomUsu"); //valor atributo name de su componente html
		String claveUsuario = request.getParameter("ptxtClaUsu");
		
		try {
			//2. Procesar petición
			UsuarioTrs adminUsu = new UsuarioTrs();
			Usuario usu = adminUsu.validarUsuario(nombreUsuario, claveUsuario);
			if(usu != null) {
				//Almacena el usuario en sesión
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", usu);
				
				//Redirecciona a un Servlet para mostrar un  menu
				//request.getRequestDispatcher("./bzx123").forward(request, response);
				
				//Redireccionar a una página JSP
				request.getRequestDispatcher("./pages/menu.mat").forward(request, response);
				
			}else {
				//Mensaje Credenciales Incorrectas
				//1.Recuperar el escritor
				PrintWriter escritor = response.getWriter();
				//2.Setear el tipo de contenido
				response.setContentType("text/html");//Si no se coloca va por defecto text/html
				//3.Escribir contenido
				escritor.print("<b><label>Credenciales Incorrectas!!!</label></b>");
				//4.Cerrar el escritor
				escritor.close();
			}
		} catch (Exception e) {
			System.err.println("Error al validar usuario.");
		}
	}
	
}
