package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Un reporte sobre el estado de un elemento
 */
@Entity
public class Reporte {
	@Id
	private int id;
	
	private int idelemento;
	
	private String descripcion;
}
