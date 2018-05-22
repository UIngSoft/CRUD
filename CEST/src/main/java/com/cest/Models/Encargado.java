package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Una persona que tendrá a su cargo varios elementos
 */
@Entity
public class Encargado {
	@Id
	private int cedula;
	
	private String nombre;


	/**
	 * @return the cedula
	 */
	public int getCedula() {
		return cedula;
	}
	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
