package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * Un bloque perteneciente a una sede de la Universidad
 */
@Entity
public class Bloque {
	
	@Id
	private char letra;
	
	@ManyToOne
	private Sede sede;
	
	private String nombre;
	
	public Bloque() {
		// TODO Auto-generated constructor stub
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
