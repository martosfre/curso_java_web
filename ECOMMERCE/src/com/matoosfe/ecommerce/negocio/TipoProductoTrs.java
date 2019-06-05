/**
 * 
 */
package com.matoosfe.ecommerce.negocio;

import org.hibernate.Session;

import com.matoosfe.ecommerce.modelo.HibernateUtil;
import com.matoosfe.ecommerce.modelo.TipoProducto;

/**
 * Clase para administrar las operaciones de tipo de producto
 * @author martosfre
 *
 */
public class TipoProductoTrs extends AbstractCrud<TipoProducto> {

	public TipoProductoTrs() {
		super(TipoProducto.class);
	}

	@Override
	public Session obtenerSesion() {
		return HibernateUtil.buildSesionFactory().openSession();
	}

}
