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
	private int codigo;
	
	@ManyToOne
	private Elemento elemento;
	private String tipocamilla;
<<<<<<< HEAD
	
	
=======
	private int encargado;
>>>>>>> b92c74f89b12fb689f20ff50c3eec23e95eaa3dd

	
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

<<<<<<< HEAD
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

=======
>>>>>>> b92c74f89b12fb689f20ff50c3eec23e95eaa3dd
	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}
<<<<<<< HEAD
=======

	public int getEncargado() {
		return encargado;
	}

	public void setEncargado(int encargado) {
		this.encargado = encargado;
	}
	
>>>>>>> b92c74f89b12fb689f20ff50c3eec23e95eaa3dd
	
	
	
}
