/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arch-linux
 */

public class EmpresaConsultar {
    
    private JdbcTemplate jdbcTemplate;

    public EmpresaConsultar() {
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    
    @RequestMapping("vistaEmpresa.htm")
    public ModelAndView vistaEmpresa(){
        ModelAndView mav = new ModelAndView();
        
        String consultaSql = "select * from empresa";
        List datos = this.jdbcTemplate.queryForList(consultaSql);
        mav.addObject("datos",datos);
        
        mav.setViewName("vistaEmpresa");
        
        return mav;
    }
     
    
}
