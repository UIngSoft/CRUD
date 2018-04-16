package connect;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * esta clase es para establecer la conexion con la base de datos
 * my sql
 * @author PABLO
 */
public class ConectarBD {
    
    /**
     * metodo que se conecta a la BD de mysql por medio del drive
     * jdbc de mysql, establecionedo el nombre de la BD, el usuario
     * y la contraseña
     * @return un archivo de tipo DriverManagerDataSource
     */
    public DriverManagerDataSource conectar(){
        
        DriverManagerDataSource data_Source = new DriverManagerDataSource();
        
        data_Source.setDriverClassName("com.mysql.jdbc.Driver");
        data_Source.setUrl("jdbc:mysql://localhost/software2");
        data_Source.setUsername("root");
        data_Source.setPassword("");
        
        return data_Source;
    }
}
