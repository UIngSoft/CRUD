/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PABLO
 */
@Controller
public class EncargadoController {
    
    
    @RequestMapping(value = "inicio.htm")
    public ModelAndView inicio(){
        
        ModelAndView modelo = new ModelAndView();
        
        modelo.setViewName("inicio");
        
        return modelo;
    }
    
    @RequestMapping(value = "agregar.htm")
    public ModelAndView agregar(){
        
        ModelAndView modelo = new ModelAndView();
        
        modelo.setViewName("agregar");
        
        return modelo;
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
