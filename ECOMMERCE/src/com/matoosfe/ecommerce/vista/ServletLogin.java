package com.matoosfe.ecommerce.vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//1. Recuperar datos enviados
		String nombreUsuario = request.getParameter("txtNomUsu"); //valor atributo name de su componente html
		String claveUsuario = request.getParameter("ptxtClaUsu");
		
		//2. Procesar petición
		UsuarioTrs adminUsu = new UsuarioTrs();
		Usuario usu = adminUsu.validarUsuario(nombreUsuario, claveUsuario);
		if(usu != null) {
			//Reenviar al Menú
		}else {
			//Mensaje Credenciales Incorrectas
			//3.Recuperar el escritor
			PrintWriter escritor = response.getWriter();
			//4.Escribir contenido
			escritor.print("<b><label>Credenciales Incorrectas!!!</label></b>");
			//5.Cerrar el escritor
			escritor.close();
		}
	}

}
