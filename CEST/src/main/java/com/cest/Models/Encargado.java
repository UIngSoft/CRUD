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

<<<<<<< HEAD
=======
	/**
	 * @return the cedula
	 */
>>>>>>> 669416525bb28225375f5c59b453c9fa08583460
	public int getCedula() {
		return cedula;
	}

<<<<<<< HEAD
=======
	/**
	 * @param cedula the cedula to set
	 */
>>>>>>> 669416525bb28225375f5c59b453c9fa08583460
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

<<<<<<< HEAD
=======
	/**
	 * @return the nombre
	 */
>>>>>>> 669416525bb28225375f5c59b453c9fa08583460
	public String getNombre() {
		return nombre;
	}

<<<<<<< HEAD
=======
	/**
	 * @param nombre the nombre to set
	 */
>>>>>>> 669416525bb28225375f5c59b453c9fa08583460
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
