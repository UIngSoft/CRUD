package com.cest.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * Una camilla que será almacenada en la base de datos
 */
@Entity
public class Camilla{
	/*Foreign Key*/
	@Id
	private int idelemento;
	
	@ManyToOne
	private Elemento elemento;
	
	private LocalDate tiemposervicio;
	private int resistencia;
	private String color;
	private float ancho;
	private float largo;
	private String material;
}
