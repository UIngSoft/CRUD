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
}
