package Modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



/**
 *
 * @author arch-linux
 */
public class ValidacionesEmpresa implements Validator{
     @Override
    public boolean supports(Class<?> type) 
    {
        return Empresa.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
         Empresa empresa=(Empresa)o;
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nit",
        "required.nit", "El campo nit es Obligatorio.");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
        "required.nombre", "El campo nombre es Obligatorio.");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion",
        "required.direccion", "El campo direccion es Obligatorio.");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono",
        "required.telefono", "El campo telefono es Obligatorio.");
    }
}

