/**
 * 
 */
package com.matoosfe.ecommerce.vista.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.matoosfe.ecommerce.modelo.Cliente;

/**
 * Clase que permite administrar el formulario de cliente
 * @author martosfre
 *
 */
@ManagedBean
@RequestScoped
public class ClienteBean {
	private Cliente cliente; //Registro
	
	public ClienteBean() {
		this.cliente = new Cliente();
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
	
	

}
