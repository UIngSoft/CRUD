package com.cest.Models;

import java.time.LocalDate;

import javax.persistence.Entity;

/*
 * Una camilla que será almacenada en la base de datos
 */
@Entity
public class Camilla extends Elemento{
	/*Foreign Key*/
	private int idelemento;
	
	private LocalDate tiemposervicio;
	private int resistencia;
	private String color;
	private float ancho;
	private float largo;
	private String material;
}
