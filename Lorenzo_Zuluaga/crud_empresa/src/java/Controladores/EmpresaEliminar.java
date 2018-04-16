
package Controladores;

import Modelos.Conexion;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class EmpresaEliminar {
    private JdbcTemplate jdbcTemplate;
    
    public EmpresaEliminar()
    {
        Conexion con=new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("eliminarEmpresa.htm")
    public ModelAndView vistaEmpresa(HttpServletRequest request) 
    {
        String nit=request.getParameter("nit");
        this.jdbcTemplate.update(
                    "delete from empresa "
                + "where "
                + "nit=? ",
        nit);
        return new ModelAndView("redirect:/vistaEmpresa.htm");
    }
}
