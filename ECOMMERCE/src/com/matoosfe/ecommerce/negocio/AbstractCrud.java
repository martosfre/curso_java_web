/**
 * 
 */
package com.matoosfe.ecommerce.negocio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.matoosfe.ecommerce.modelo.Cliente;

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
		Transaction transaccion = null;
		String mensaje = "Registro guardado correctamente";
		try(Session session = obtenerSesion()){
			transaccion = session.beginTransaction();
			session.save(objeto);
			transaccion.commit();
		}catch(Exception e) {
			transaccion.rollback();
			mensaje = "Error al guardar";
			throw new Exception(mensaje);
		}
		
	
		return mensaje;
	}
	
	/**
	 * Método para actualizar un objeto
	 * @param objeto
	 * @return
	 * @throws Exception
	 */
	public String actualizar(T objeto) throws Exception {
		Transaction transaccion = null;
		String mensaje = "Registro actualizado correctamente";
		try(Session session = obtenerSesion()){
			transaccion = session.beginTransaction();
			session.update(objeto);
			transaccion.commit();
		}catch(Exception e) {
			transaccion.rollback();
			mensaje = "Error al actualizar";
			throw new Exception(mensaje);
		}
		return mensaje;
	}
	
	/**
	 * Método para eliminar un objeto
	 * @param objeto
	 * @return
	 * @throws Exception
	 */
	public String eliminar(T objeto) throws Exception {
		Transaction transaccion = null;
		String mensaje = "Registro eliminado correctamente";
		try(Session session = obtenerSesion()){
			transaccion = session.beginTransaction();
			session.delete(objeto);
			transaccion.commit();
		}catch(Exception e) {
			transaccion.rollback();
			mensaje = "Error al eliminar";
			throw new Exception(mensaje);
		}
		return mensaje;
	}
	
	/**
	 * Método para consultar todos los objetos
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<T> consultarTodos() throws Exception{
		Transaction transaccion = null;
		List<T> listaObjetos = null;
		try(Session session = obtenerSesion()){
			transaccion = session.beginTransaction();
			listaObjetos = session.createQuery( "from " + objeto.getSimpleName()).list();
			transaccion.commit();
		}catch(Exception e) {
			transaccion.rollback();
			throw new Exception("Error al recuperar los registros");
		}
		return listaObjetos;
	}
	
	@SuppressWarnings("unchecked")
	public T consultarPorId(String atributoId, Integer id) throws Exception{
		Transaction transaccion = null;
		T objetoDev = null;
		try(Session session = obtenerSesion()){
			transaccion = session.beginTransaction();
			Query<T> consulta = session.createQuery( "select alias from " + objeto.getSimpleName() + " alias where alias." + atributoId + "= :id");
			consulta.setParameter("id", id);
			objetoDev = (T) consulta.getSingleResult();
			transaccion.commit();
		}catch(Exception e) {
			transaccion.rollback();
			throw new Exception("Error al recuperar los registros");
		}
		return objetoDev;
	}

	public abstract Session obtenerSesion();

}
