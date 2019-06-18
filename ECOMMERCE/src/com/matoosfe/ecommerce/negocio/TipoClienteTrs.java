/**
 * 
 */
package com.matoosfe.ecommerce.negocio;

import org.hibernate.Session;

import com.matoosfe.ecommerce.modelo.HibernateUtil;
import com.matoosfe.ecommerce.modelo.TipoCliente;

/**
 * Clase para administrar las operaciones de cliente
 * @author martosfre
 *
 */
public class TipoClienteTrs extends AbstractCrud<TipoCliente> {

	public TipoClienteTrs() {
		super(TipoCliente.class);
	}

	@Override
	public Session obtenerSesion() {
		return HibernateUtil.buildSesionFactory().openSession();
	}

}
