package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Ficha tecnica de un extintor
 */
@Entity
public class Fichatecnica {
	@Id
	private String tipo;
	
	private String descripcion;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
