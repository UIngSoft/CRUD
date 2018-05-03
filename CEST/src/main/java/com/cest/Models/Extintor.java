package com.cest.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/*
 * Un extintor que será registrado en el sistema
 */
@Entity
public class Extintor{
	/*Foreign Key*/
	@Id
	private int idelemento;
	
	@ManyToOne
	private Elemento elemento;
	
	
	@OneToOne
	private Fichatecnica fichatecnica;
	
	private int tamanio;
	private LocalDate fechainstalacion;
	private LocalDate fechaultimarecarga;
	private LocalDate fechavencimiento;
	private String estado;
	private int caducidadanios;
	private String observacion;
}
