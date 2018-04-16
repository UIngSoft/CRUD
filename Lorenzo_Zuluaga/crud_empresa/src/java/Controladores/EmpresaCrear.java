/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Conexion;
import Modelos.Empresa;
import Modelos.ValidacionesEmpresa;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arch-linux
 */
@Controller
@RequestMapping("crearEmpresa.htm")
public class EmpresaCrear {
    ValidacionesEmpresa validacion;
    private JdbcTemplate jdbcTemplate;

    public EmpresaCrear() {
        Conexion con = new Conexion();
        this.validacion = new ValidacionesEmpresa();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("crearEmpresa");
        mav.addObject("empresa", new Empresa());
        return mav;
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("empresa") Empresa e,BindingResult result,SessionStatus status){
        this.jdbcTemplate.update("insert into empresa (nit,nombre,direccion,telefono) values (?,?,?,?)",e.getNit(),e.getNombre(), e.getDireccion(), e.getTelefono());
         return new ModelAndView("redirect:/vistaEmpresa.htm");
    
    }
       
}

    

