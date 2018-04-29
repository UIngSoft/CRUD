package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Un piso perteneciente a un bloque de la sede
 */
@Entity
public class Piso {
	@Id
	private int numero;
	/*Foreign key*/
	private char letraBloque;
}
