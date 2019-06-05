/**
 * 
 */
package com.matoosfe.ecommerce.negocio;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Clase genérica para las operaciones CRUD en hibernate
 * 
 * @author martosfre
 *
 */
public abstract class AbstractCrud<T> {
	
	private Class<T> objeto;

	public AbstractCrud(Class<T> objeto) {
		this.objeto = objeto;
	}

	/**
	 * Método para guardar un registro
	 * @param objeto
	 * @return
	 * @throws Exception
	 */
	public String guardar(T objeto) throws Exception {
		String mensaje = null;
		Session session = obtenerSesion();
		session.beginTransaction();
		session.save(objeto);
		session.getTransaction().commit();
		return mensaje;
	}
	
	/**
	 * Método para actualizar un objeto
	 * @param objeto
	 * @return
	 * @throws Exception
	 */
	public String actualizar(T objeto) throws Exception {
		String mensaje = null;
		Session session = obtenerSesion();
		session.beginTransaction();
		session.update(objeto);
		session.getTransaction().commit();
		return mensaje;
	}
	
	/**
	 * Método para eliminar un objeto
	 * @param objeto
	 * @return
	 * @throws Exception
	 */
	public String eliminar(T objeto) throws Exception {
		String mensaje = null;
		Session session = obtenerSesion();
		session.beginTransaction();
		session.delete(objeto);
		session.getTransaction().commit();
		return mensaje;
	}
	
	/**
	 * Método para consultar todos los objetos
	 * @return
	 */
	public List<T> consultarTodos(){
		Session session = obtenerSesion();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<T> listaObjetos = session.createQuery( "from " + objeto.getSimpleName()).list();
		session.getTransaction().commit();
		return listaObjetos;
	}

	public abstract Session obtenerSesion();

}
