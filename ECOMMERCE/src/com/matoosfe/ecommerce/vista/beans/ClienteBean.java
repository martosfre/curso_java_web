/**
 * 
 */
package com.matoosfe.ecommerce.vista.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.matoosfe.ecommerce.modelo.Cliente;
import com.matoosfe.ecommerce.negocio.ClienteTrs;

/**
 * Clase que permite administrar el formulario de cliente En esta clase se
 * definen los objetos, atributos que van a interactuar en la vista y también
 * las operaciones
 * 
 * @author martosfre
 *
 */
@ManagedBean
@RequestScoped
public class ClienteBean {

	private Cliente cliente;
	private ClienteTrs adminCliente;

	public ClienteBean() {
		this.cliente = new Cliente(); // Registro Vacio
		this.adminCliente = new ClienteTrs();
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/********************************
	 * OPERACIONES en JSF
	 *********************************/
	public String guardar() {
		try {
			String mensaje = adminCliente.guardar(cliente);
			cliente = new Cliente();
			//Crear Mensaje
			FacesMessage mensajeJSF = new FacesMessage();
			mensajeJSF.setDetail(mensaje);
			//Añadir el Mensaje
			FacesContext.getCurrentInstance().addMessage(null, mensajeJSF);
		} catch (Exception e) {
			//Crear Mensaje
			FacesMessage mensajeJSF = new FacesMessage();
			mensajeJSF.setDetail("Error al guardar");
			//Añadir el Mensaje
			FacesContext.getCurrentInstance().addMessage(null, mensajeJSF);
		}
		return null; //Si se coloca null se queda en la misma página
	}
}
