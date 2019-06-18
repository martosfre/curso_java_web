/**
 * 
 */
package com.matoosfe.ecommerce.negocio;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.matoosfe.ecommerce.modelo.HibernateUtil;
import com.matoosfe.ecommerce.modelo.Usuario;

/**
 * Clase para administrar las operaciones de Usuario
 * 
 * @author martosfre
 *
 */
public class UsuarioTrs extends AbstractCrud<Usuario> {

	public UsuarioTrs() {
		super(Usuario.class);
	}

	@SuppressWarnings("unchecked")
	public Usuario validarUsuario(String nombreUsuario, String claveUsuario) throws Exception {
		Transaction transaccion = null;
		Usuario usuarioDev = null;
		try (Session session = obtenerSesion()) {
			transaccion = session.beginTransaction();
			Query<Usuario> consulta = session.createQuery(
					"select usu from Usuario usu where usu.nombreUsu =:paramNomUsu and usu.claveUsu =:paramClaUsu");
			consulta.setParameter("paramNomUsu", nombreUsuario);
			consulta.setParameter("paramClaUsu", claveUsuario);
			usuarioDev = consulta.getSingleResult();
			transaccion.commit();
		} catch (Exception e) {
			usuarioDev = null;
		}
		return usuarioDev;
	}

	@Override
	public Session obtenerSesion() {
		return HibernateUtil.buildSesionFactory().openSession();
	}

}
