package com.cest.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cest.LlavesCompuestas.PisoPK;

/*
 * Un piso perteneciente a un bloque de la sede
 */
@Entity
public class Piso{
<<<<<<< HEAD
=======
	@Id
	private int numero;
	@ManyToOne
	private Bloque bloque;
	
>>>>>>> 8be1d27fecc6a72e2e298ffd0e927cd62c97d704
	public Piso() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Llave compuesta
	
	 //Se define la llave primaria compuesta 
    //metodo getter que representa la llave primaria compuesta
    public PisoPK getPisoPk() {
        if (this.pisoPk == null) {
            this.pisoPk = new PisoPK();        
        }
        return pisoPk;
    }

    /** Metodo setter que representa la llave primaria compuesta */
    public void setPisoPk(final PisoPK pisoPk) {
        this.pisoPk = pisoPk;
    }

    /** @generated */
    @EmbeddedId
    private PisoPK pisoPk = new PisoPK();
	
	//Fin llave compuesta
    
    @ManyToOne
	private Bloque bloque;

	/**
	 * @return the bloque
	 */
	public Bloque getBloque() {
		return bloque;
	}

	/**
	 * @param bloque the bloque to set
	 */
	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}
}
