package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * Un piso perteneciente a un bloque de la sede
 */
@Entity
public class Piso{
	@Id
	private int numero;
	

	@ManyToOne
	private Bloque bloque;
	
	public Piso() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the bloque
	 */
	public Bloque getBloque() {
		return bloque;
	}

	/**
	 * @param bloque the bloque to set
	 */
	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}
}
