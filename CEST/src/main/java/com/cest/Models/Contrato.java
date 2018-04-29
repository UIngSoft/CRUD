package com.cest.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Un contrato que tendrá involucrados diferentes elementos
 */
@Entity
public class Contrato {
	@Id
	private int numero;
	/*Foreign Key*/
	private int nitempresa;
	
	private LocalDate fecha;
	private float valor;
	private String descripcion;
}
