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

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
