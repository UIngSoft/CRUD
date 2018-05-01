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
	
	private String id;
	private String tipo;
	private String tamaño;
	private String ubicacion;
	private LocalDate fechaUltimaRecarga;
	private LocalDate fechaProximaRecarga;
	private String caducidad;
	private float encargado;
	private String estado;
	private String nitEmpresa;
}
