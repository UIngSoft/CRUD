/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import models.Encargado;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author PABLO
 */
public class EncargadoValidation implements Validator{

        /**
     * se relacionan las clases que van a tener metodos de validacion
     */
    @Override
    public boolean supports(Class<?> type) {
        return Encargado.class.isAssignableFrom(type);
    }

    /**
     * clase para crear los metos de validacion para los campos
     * del formulario agragr de encargado
     */
    @Override
    public void validate(Object o, Errors errors) {
        Encargado encargado = (Encargado)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cedula", "required.cedula","El campo Cedula es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre", "El campo Nombre es oblgatorio");
    }
    
}
