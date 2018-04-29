package com.cest.Models;

import java.time.LocalDate;

import javax.persistence.Entity;

/*
 * Un extintor que será registrado en el sistema
 */
@Entity
public class Extintor extends Elemento{
	/*Foreign Key*/
	private int idelemento;
	/*Foreign Key*/
	private String tipo;
	
	private int tamanio;
	private LocalDate fechainstalacion;
	private LocalDate fechaultimarecarga;
	private LocalDate fechavencimiento;
	private String estado;
	private int caducidadanios;
	private String observacion;
}
