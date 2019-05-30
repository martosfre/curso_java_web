package com.matoosfe.ecommerce.vista;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.matoosfe.ecommerce.modelo.Usuario;

/**
 * Servlet Generico extiende de GenericServlet
 */
@WebServlet("/ServletLoginDos")
public class ServletLoginDos extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public ServletLoginDos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// Este método reemplaza al doPost y doGet
		HttpServletRequest reqhttp = (HttpServletRequest) request;
		HttpSession sesion = reqhttp.getSession();
		sesion.setAttribute("usuario", new Usuario());
	}

}
