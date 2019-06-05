/**
 * 
 */
package com.matoosfe.ecommerce.negocio;

import org.hibernate.Session;

import com.matoosfe.ecommerce.modelo.HibernateUtil;
import com.matoosfe.ecommerce.modelo.Usuario;

/**
 * Clase para administrar las operaciones de Usuario
 * @author martosfre
 *
 */
public class UsuarioTrs extends AbstractCrud<Usuario> {

	public UsuarioTrs() {
		super(Usuario.class);
	}

	public Usuario validarUsuario(String nombreUsuario, String claveUsuario) {
		return new Usuario();
	}

	@Override
	public Session obtenerSesion() {
		return HibernateUtil.buildSesionFactory().openSession();
	}

}
