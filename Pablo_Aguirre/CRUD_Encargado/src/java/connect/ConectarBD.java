/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author PABLO
 */
public class ConectarBD {
    
    public DriverManagerDataSource conectar(){
        
        DriverManagerDataSource data_Source = new DriverManagerDataSource();
        
        data_Source.setDriverClassName("com.mysql.jdbc.Driver");
        data_Source.setUrl("jdbc:mysql://localhost/software2");
        data_Source.setUsername("root");
        data_Source.setPassword("");
        
        return data_Source;
    }
}
