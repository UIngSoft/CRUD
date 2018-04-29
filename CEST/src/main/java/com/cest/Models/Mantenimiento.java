package com.cest.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Detalle mantenimiento de un elemento
 */
@Entity
public class Mantenimiento {
	@Id
	private int consecutivo;
	/*Foreign Key*/
	
	private String descripcion;
	private LocalDate fecharealizacion;
}
