/**
 * 
 */
package com.matoosfe.ecommerce.vista.beans;

import java.util.ArrayList;
import java.util.List;

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
	private String estiloMensaje;
	private List<Cliente> listaClientes;

	public ClienteBean() {
		this.cliente = new Cliente(); // Registro Vacio
		this.adminCliente = new ClienteTrs();
		this.estiloMensaje = "color:red;";
		this.listaClientes = new ArrayList<>();
		inicializarTabla();
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

	/**
	 * @return the estiloMensaje
	 */
	public String getEstiloMensaje() {
		return estiloMensaje;
	}

	/**
	 * @param estiloMensaje the estiloMensaje to set
	 */
	public void setEstiloMensaje(String estiloMensaje) {
		this.estiloMensaje = estiloMensaje;
	}

	/**
	 * @return the listaClientes
	 */
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	/**
	 * @param listaClientes the listaClientes to set
	 */
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	/********************************
	 * OPERACIONES en JSF
	 *********************************/
	public String guardar() {
		try {
			String mensaje = adminCliente.guardar(cliente);
			cliente = new Cliente();
			inicializarTabla();
			// Crear Mensaje
			FacesMessage mensajeJSF = new FacesMessage();
			mensajeJSF.setSeverity(FacesMessage.SEVERITY_INFO);
			mensajeJSF.setSummary(mensaje);
			// Cambiar el color
			estiloMensaje = "color:negro;";
			// Añadir el Mensaje
			FacesContext.getCurrentInstance().addMessage(null, mensajeJSF);
		} catch (Exception e) {
			// Crear Mensaje
			FacesMessage mensajeJSF = new FacesMessage();
			mensajeJSF.setSeverity(FacesMessage.SEVERITY_ERROR);
			mensajeJSF.setSummary("Error al guardar");
			// Cambiar el color
			estiloMensaje = "color:red;";
			// Añadir el Mensaje
			FacesContext.getCurrentInstance().addMessage(null, mensajeJSF);
		}
		return null; // Si se coloca null se queda en la misma página
	}

	/**
	 * Método para inicializar la tabla de clientes
	 */
	private void inicializarTabla() {
		try {
			this.listaClientes = adminCliente.consultarTodos();
		} catch (Exception e) {
			// Crear Mensaje
			FacesMessage mensajeJSF = new FacesMessage();
			mensajeJSF.setSeverity(FacesMessage.SEVERITY_ERROR);
			mensajeJSF.setSummary("Error al consultar clientes");
			// Cambiar el color
			estiloMensaje = "color:red;";
			// Añadir el Mensaje
			FacesContext.getCurrentInstance().addMessage(null, mensajeJSF);
		}

	}
}
