package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Una sede de la Universidad
 */
@Entity
public class Sede {
	@Id
	private int id;
	
	private String nombre;
}
