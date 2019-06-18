/**
 * 
 */
package com.matoosfe.ecommerce.vista.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.matoosfe.ecommerce.modelo.Cliente;
import com.matoosfe.ecommerce.modelo.TipoCliente;
import com.matoosfe.ecommerce.negocio.ClienteTrs;
import com.matoosfe.ecommerce.negocio.TipoClienteTrs;

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
	private TipoClienteTrs adminTipoCliente;

	private String estiloMensaje;
	private List<Cliente> listaClientes;
	private List<SelectItem> listaTiposClientes;

	public ClienteBean() {
		this.cliente = new Cliente(); // Registro Vacio
		this.cliente.setTipoCliente(new TipoCliente()); // Relación
		this.adminCliente = new ClienteTrs();
		this.adminTipoCliente = new TipoClienteTrs();
		this.estiloMensaje = "color:red;";
		this.listaClientes = new ArrayList<>();
		this.listaTiposClientes = new ArrayList<>();
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

	/**
	 * @return the listaTiposClientes
	 */
	public List<SelectItem> getListaTiposClientes() {
		return listaTiposClientes;
	}

	/**
	 * @param listaTiposClientes the listaTiposClientes to set
	 */
	public void setListaTiposClientes(List<SelectItem> listaTiposClientes) {
		this.listaTiposClientes = listaTiposClientes;
	}

	/********************************
	 * OPERACIONES en JSF
	 *********************************/
	public String guardar() {
		try {
			String mensaje = null;
			if (cliente.getIdCli() == 0) {
				mensaje = adminCliente.guardar(cliente);
			} else {
				mensaje = adminCliente.actualizar(cliente);
			}
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
	 * Método para editar un registro
	 * 
	 * @return
	 */
	public String editar() {
		try {
			/**********************************************************************
			 * Recuperar parámetros
			 ********************************************************************/
			FacesContext contextoJSF = FacesContext.getCurrentInstance();
			ExternalContext contextoServlet = contextoJSF.getExternalContext();
			Integer idCli = Integer.parseInt(contextoServlet.getRequestParameterMap().get("idCli"));
			/******************************************************************************************/
			// Recupero el Cliente y le asigno a la variable que representa el formulario de
			// guardar
			cliente = adminCliente.consultarPorId("idCli", idCli);

		} catch (Exception e) {
			// Crear Mensaje
			FacesMessage mensajeJSF = new FacesMessage();
			mensajeJSF.setSeverity(FacesMessage.SEVERITY_ERROR);
			mensajeJSF.setSummary("Error al editar");
			// Cambiar el color
			estiloMensaje = "color:red;";
			// Añadir el Mensaje
			FacesContext.getCurrentInstance().addMessage(null, mensajeJSF);
		}

		return null;
	}

	/**
	 * Método para eliminar un registro
	 * 
	 * @return
	 */
	public String eliminar() {
		try {
			/**********************************************************************
			 * Recuperar parámetros
			 ********************************************************************/
			FacesContext contextoJSF = FacesContext.getCurrentInstance();
			ExternalContext contextoServlet = contextoJSF.getExternalContext();
			Integer idCli = Integer.parseInt(contextoServlet.getRequestParameterMap().get("idCli"));
			/******************************************************************************************/
			/*
			 * Recupero el Cliente y le asigno a la variable que representa el formulario de
			 * guardar
			 */
			// Eliminar
			String mensaje = adminCliente.eliminar(adminCliente.consultarPorId("idCli", idCli));
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
			mensajeJSF.setSummary("Error al editar");
			// Cambiar el color
			estiloMensaje = "color:red;";
			// Añadir el Mensaje
			FacesContext.getCurrentInstance().addMessage(null, mensajeJSF);
		}

		return null;
	}

	/**
	 * Método para inicializar la tabla de clientes
	 */
	private void inicializarTabla() {
		try {
			this.listaClientes = adminCliente.consultarTodos();
			for(TipoCliente tipCli:adminTipoCliente.consultarTodos()) {
				this.listaTiposClientes.add(new SelectItem(tipCli.getIdTipcli(), tipCli.getNombreTipcli()));
			}
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
