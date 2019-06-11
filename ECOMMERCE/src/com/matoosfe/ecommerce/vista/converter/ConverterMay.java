/**
 * 
 */
package com.matoosfe.ecommerce.vista.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Clase para convertir los textos en Mayusculas
 * 
 * @author martosfre
 *
 */
@FacesConverter("conMay")
public class ConverterMay implements Converter<String> {

	// Va a la bdd
	@Override
	public String getAsObject(FacesContext contexto, UIComponent componente, String cadenaForm) {
		String cadenaConv = null;
		if (cadenaForm != null) {
			cadenaConv = cadenaForm.toUpperCase();
		} else {
			throw new ConverterException("Error al convertir: El campo es nulo");
		}
		return cadenaConv;
	}

	// Viene de la bdd
	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, String cadenaBdd) {
		String cadenaConv = null;
		if (cadenaBdd != null) {
			cadenaConv = cadenaBdd.toUpperCase();
		} else {
			throw new ConverterException("Error al convertir: El campo es nulo");
		}
		return cadenaConv;
	}

}
