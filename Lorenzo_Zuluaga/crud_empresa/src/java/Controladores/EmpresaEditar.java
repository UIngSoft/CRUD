/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Modelos.Conexion;
import Modelos.Empresa;
import Modelos.ValidacionesEmpresa;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("editarEmpresa.htm")
public class EmpresaEditar
{
    ValidacionesEmpresa validacion;
    private JdbcTemplate jdbcTemplate;
     
    
    public EmpresaEditar() 
    {
        this.validacion=new ValidacionesEmpresa();
        Conexion con = new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        int nit=Integer.parseInt(request.getParameter("nit"));

        Empresa datos = this.selectEmpresa(nit);
        mav.setViewName("editarEmpresa");
        mav.addObject("empresa",new Empresa(datos.getNit(),datos.getNombre(),datos.getDireccion(), datos.getTelefono()));
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("empresa") Empresa u,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        this.validacion.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            
            int nit=Integer.parseInt(request.getParameter("nit"));
            String nombre=request.getParameter("nombre");
            String direccion=request.getParameter("direccion");
            int telefono=Integer.parseInt(request.getParameter("telefono"));
            Empresa datos = this.selectEmpresa(nit);
            mav.setViewName("editarEmpresa");
            mav.addObject("empresa",new Empresa(datos.getNit(),datos.getNombre(),datos.getDireccion(), datos.getTelefono()));
            return mav;
        }else
        {
        String nit=request.getParameter("nit");
        this.jdbcTemplate.update("update empresa "
                                + "set nit=?,"
                                + "nombre=?,"
                                + "direccion=?, "
                                + "telefono=?, "
                                + "where "
                                + "nit=?",
         u.getNit(),u.getNombre(),u.getDireccion(), u.getTelefono(),nit);
         return new ModelAndView("redirect:/vistaEmpresa.htm");
        }
    }
        
    public Empresa selectEmpresa(int nit) 
    {
        final Empresa empresa = new Empresa();
        String query = "SELECT * FROM empresa WHERE nit = "+nit;
        return (Empresa) jdbcTemplate.query
        (query, new ResultSetExtractor<Empresa>() 
            {
                public Empresa extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        empresa.setNombre(rs.getString("nombre"));
                        empresa.setDireccion(rs.getString("direccion"));
                        empresa.setTelefono(rs.getInt("telefono"));
                    }
                    return empresa;
                }
            }
        );
    }
}

