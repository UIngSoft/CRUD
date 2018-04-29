package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Un bloque perteneciente a una sede de la Universidad
 */
@Entity
public class Bloque {
	@Id
	private char letra;
	/*Foreign Key*/
	private int idSede;
	
	private String nombre;
}
