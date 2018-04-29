package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Una empresa que suministra los elementos
 */
@Entity
public class Empresa {
	@Id
	private int nit;
	
	private String nombre;
	private int telefono;
	private String direccion;
}
