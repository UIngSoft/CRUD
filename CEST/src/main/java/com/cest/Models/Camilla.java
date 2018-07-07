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
	private int encargado;
	private String tipocamilla;

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
	
	/*	
	 * @return encargado
	 */
	public int getEncargado() {
		return encargado;
	}
	
	/**
	 * @param encargado the encargado to set
	 */
	public void setTipocamilla(int encargado) {
		this.encargado = encargado;
	}
	
	
	
	
}
