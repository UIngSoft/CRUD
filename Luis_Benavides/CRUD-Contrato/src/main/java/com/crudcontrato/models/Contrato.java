package com.crudcontrato.models;

/*
 * Un contrato que será registrado en la base de datos
 * @author Luis Trejos
 * @version 1.0
 */
public class Contrato {

	private int id;
	private String nombre;
	private String fechainicio;
	private String fechafin;
	
	/*
	 * Crea un contrato con valores vacíos
	 */
	public Contrato() {
		this.id=0;
		this.nombre = "";
		this.fechainicio = "";
		this.fechafin = "";
	}
	
	/*
	 * Crea un contrato con los valores enviados
	 * @param id El id del contrato
	 * @param nombre El nombre del contrato
	 * @param fechainicio La fecha de inicio del contrato
	 * @param fechafin La fecha de finalizacion del contrato
	 */
	public Contrato(int id, String nombre, String fechainicio, String fechafin) {
		this.id = id;
		this.nombre = nombre;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
	}
	
	/*
	 * Sets y Gets
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}
	
	public String getFechainicio() {
		return this.fechainicio;
	}
	
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}
	
	public String getFechafin() {
		return this.fechafin;
	}
	
}

