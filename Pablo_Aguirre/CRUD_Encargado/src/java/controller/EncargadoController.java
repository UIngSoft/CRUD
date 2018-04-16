package controller;

import connect.ConectarBD;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.Encargado;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import validation.EncargadoValidation;

/**
 * es la clase que se encarga de relacionar la url con la vista
 * correspondiente, tambien realiza las peticiones get y post de los formularios
 * de las interfaces
 * @author PABLO
 */
@Controller
public class EncargadoController {
    
    private EncargadoValidation validarencargado;
    private JdbcTemplate jdbc;

    public EncargadoController() {
        ConectarBD conexion = new ConectarBD();
        this.validarencargado = new EncargadoValidation();
        this.jdbc = new JdbcTemplate(conexion.conectar());
    }    
    
    @RequestMapping(value = "inicio.htm")
    public ModelAndView inicio(){        
        ModelAndView modelo = new ModelAndView();        
        modelo.setViewName("inicio");        
        return modelo;
    }
    
    @RequestMapping("mostrar.htm")
    public ModelAndView mostrar(){        
        ModelAndView modelo = new ModelAndView();        
        String sql = "SELECT * FROM encargado";
        List datos=this.jdbc.queryForList(sql);
        modelo.addObject("datos", datos);
        modelo.setViewName("mostrar");        
        return modelo;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView agregar(){        
        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("agregar");
        modelo.addObject("encargado", new Encargado());
        return modelo;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView agregar(@ModelAttribute("encargado") Encargado encargado,
                                BindingResult resultado,
                                SessionStatus status){
        
        this.validarencargado.validate(encargado, resultado);
        
        if (resultado.hasErrors()) {
            //como el campo no cumple con el parametro volvemos al formulario
            // se ejecuto la validacion
            ModelAndView modelo = new ModelAndView();
            modelo.setViewName("agregar");
            modelo.addObject("encargado", new Encargado());
            return modelo;
        } else {
            // se envian los datos por del formulario
            this.jdbc.update(
                    "insert into encargado values(?,?,?,?,?,?,?,?,?)",
                    encargado.getCedula(), encargado.getNombre(), encargado.getApellido(), 
                    encargado.getCelular(), encargado.getCorreo(), encargado.getCargo(),
                    encargado.getSede(), encargado.getFacultad(), encargado.getPrograma());
            
            return new ModelAndView("redirect:/inicio.htm");
        }
    }
    
    
    
    @RequestMapping(value = "buscar.htm")
    public ModelAndView buscar(){        
        ModelAndView modelo = new ModelAndView();        
        modelo.setViewName("buscar");        
        return modelo;
    }
    
    @RequestMapping(value = "editar.htm")
    public ModelAndView editar(){        
        ModelAndView modelo = new ModelAndView();        
        modelo.setViewName("editar");        
        return modelo;
    }
 }
