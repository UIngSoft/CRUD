package com.crudcontrato.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import org.springframework.stereotype.Component;
import com.crudcontrato.models.Contrato;
import java.util.List;
import java.sql.Connection;


/*
 * Un objeto de acceso a datos
 * se conecta con la base de datos
 * para la gestion necesesaria de los contratos
 * @author Luis Trejos
 * @version 1.0
 */
@Component
public class ContratoDao {
	
	Connection con = null;
	ResultSet rs = null;
	Statement stmt = null;
	String url="jdbc:mysql://localhost:3306/ingesoft2";
	List<Contrato> contratos;
	
	/*
	 * Crea un objeto de acceso a datos
	 * Realiza conexion con la base de datos
	 */
	public ContratoDao() {
		try {
			con = DriverManager.getConnection(url,"root","");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Retorna una lista con los contratos obtenidos de la base de datos
	 * @return contratos Lista de contratos
	 */
	public List<Contrato> getContratos(){
		return this.contratos;
	}

	/*
	 * Registra un contrato en la base de datos
	 * @param contrato Contrato enviado desde el controlador
	 */
	public void create(Contrato contrato) {
		String sql = "insert into contrato(id,nombre,fecha_inicio,fecha_fin) "
		  		+ "values ('" + contrato.getId() + "','"+contrato.getNombre()+"','"+contrato.getFechainicio()+"','"+contrato.getFechafin()+"')";
		try {
			stmt.executeUpdate(sql);
			 
		} catch (SQLException sqle) { 
			System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());    
		}
	}
		 
	/*
	 * Consulta todos los registros de la tabla contratos de la base de datos
	 * Llena la lista de contratos con todos los registros que devuelve la consulta realizada
	 */
	public void read() {
		contratos = new LinkedList<>();
		String sql = "select * from contrato";
		try {
			stmt.executeQuery(sql);
			ResultSet rs = stmt.getResultSet();
			if (!rs.next())
		        System.out.println("no hay registros");
		    else 
		    	do {
		            contratos.add(new Contrato(Integer.valueOf(rs.getString("id")),rs.getString("nombre"),rs.getString("fecha_inicio"),rs.getString("fecha_fin")));
		        } while (rs.next());
		} catch (SQLException sqle) { 
			System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());    
		}
	}
	
	/*
	 * Consulta un contrato de la base de datos
	 * @param id El id del contrato a consultar
	 * @return infocontrato La informacion del contrato consultado en la base de datos
	 */
	public String readId(int id) {
		String sql = "select * from contrato where id=" + id + "";
		String infocontrato= "";
		try {
			stmt.executeQuery(sql);
			ResultSet rs = stmt.getResultSet();
			if (!rs.next())
				infocontrato = "No existe el ID : "+id;
			else 
				do {
					infocontrato = "ID: "+rs.getString("id")+"\nNombre: "+rs.getString("nombre")
		            	+"\nFecha inicio: "+rs.getString("fecha_inicio")+"\nFecha fin: "+rs.getString("fecha_fin");
		        } while (rs.next());
		} catch (SQLException sqle) { 
			System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());    
		}
		return infocontrato;
	}
		 
	/*
	 * Actualiza la informacion de un contrato de la base de datos
	 * @param contrato El contrato que será actualizado
	 */
	public void update(Contrato contrato) {
		String sql = "update contrato set nombre='" + contrato.getNombre() + "', fecha_inicio='" + contrato.getFechainicio() + "', fecha_fin='"
		    + contrato.getFechafin() + "' where id=" + contrato.getId() + "";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			  stmt.executeUpdate();
		} catch (SQLException sqle) { 
			System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());    
		}
	}

	/*
	 * Elimina un contrato de la base de datos
	 * @param id El id del contrato que será eliminado
	 */
	public void delete(int id) {
		String sql = "delete from contrato where id=" + id + "";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.executeUpdate(); 
		} catch (SQLException sqle) { 
			System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());    
		}
	}
}