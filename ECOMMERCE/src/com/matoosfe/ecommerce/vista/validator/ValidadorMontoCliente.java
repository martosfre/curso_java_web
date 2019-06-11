/**
 * 
 */
package com.matoosfe.ecommerce.vista.validator;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Clase para validar la cuota del cliente
 * @author martosfre
 *
 */
@FacesValidator("valMonCli")
public class ValidadorMontoCliente implements Validator<BigDecimal> {

	@Override
	public void validate(FacesContext contexto, UIComponent componente, BigDecimal valor) throws ValidatorException {
		FacesMessage mensajeJSF = new FacesMessage();
		mensajeJSF.setSeverity(FacesMessage.SEVERITY_ERROR);
		if(valor != null) {
			if(valor.doubleValue() < 2000 || valor.doubleValue() > 5000) {
				mensajeJSF.setSummary("Error en el monto de la cuota, solo se permite de 2000 a 5000");
				throw new ValidatorException(mensajeJSF);
			}
		}else {
			mensajeJSF.setSummary("El valor ingresado es nulo");
			throw new ValidatorException(mensajeJSF);
		}
		
	}

}
