/**
 * 
 */
package com.matoosfe.ecommerce.negocio;

import org.hibernate.Session;

import com.matoosfe.ecommerce.modelo.Cliente;
import com.matoosfe.ecommerce.modelo.HibernateUtil;

/**
 * Clase para administrar las operaciones de cliente
 * @author martosfre
 *
 */
public class ClienteTrs extends AbstractCrud<Cliente> {

	public ClienteTrs() {
		super(Cliente.class);
	}

	@Override
	public Session obtenerSesion() {
		return HibernateUtil.buildSesionFactory().openSession();
	}

}
