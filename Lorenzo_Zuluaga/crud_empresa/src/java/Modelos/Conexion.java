/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author arch-linux
 */
public class Conexion {
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/bd_prueba");
        dataSource.setUsername("root");
        dataSource.setPassword("123456789");
        
        return dataSource;
    }
}
