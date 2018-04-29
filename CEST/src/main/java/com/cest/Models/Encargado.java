package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Una persona que tendrá a su cargo varios elementos
 */
@Entity
public class Encargado {
	@Id
	private int cedula;
	
	private String nombre;
}
