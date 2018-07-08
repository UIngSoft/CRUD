package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * Una camilla que será almacenada en la base de datos
 */
@Entity
public class Camilla{
	/*Primary Key*/
	@Id
	private int idelemento;
	
	@ManyToOne
	private Elemento elemento;
	private String tipocamilla;
	private int encargado;

	
	/**
	 * @return the tipocamilla
	 */
	public int getIdElemento() {
		return idelemento;
	}
	
	/**
	 * @return the tipocamilla
	 */
	public String getTipocamilla() {
		return tipocamilla;
	}

	/*
	 * @param tipocamilla the tipocamilla to set
	 */
	public void setTipocamilla(String tipocamilla) {
		this.tipocamilla = tipocamilla;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public int getEncargado() {
		return encargado;
	}

	public void setEncargado(int encargado) {
		this.encargado = encargado;
	}
	
	
	
	
}
