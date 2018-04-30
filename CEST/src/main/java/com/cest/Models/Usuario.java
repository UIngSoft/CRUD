package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	private String contrasena;
	
	private String usuario;
}
