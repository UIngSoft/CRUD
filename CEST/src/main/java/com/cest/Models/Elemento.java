package com.cest.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Un elemento que será registrado en el sistema
 */
@Entity
@Table(name = "elemento")
public class Elemento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private int id;
	/*Foreign Key*/
	private int numeropiso;
	/*Foreign Key*/
	private int numerocontrato;
	/*Foreign Key*/
	private int cedulaencargado;
	/*Foreign Key*/
	private int consecutivomantenimiento;
	
	public Elemento() {
		/*this.id = 0;
		this.numeropiso = 0;
		this.numerocontrato = 0;
		this.cedulaencargado = 0;
		this.consecutivomantenimiento = 0;*/
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumeropiso() {
		return numeropiso;
	}
	public void setNumeropiso(int numeropiso) {
		this.numeropiso = numeropiso;
	}
	
	public int getNumerocontrato() {
		return numerocontrato;
	}
	public void setNumerocontrato(int numerocontrato) {
		this.numerocontrato = numerocontrato;
	}
	
	public int getCedulaencargado() {
		return cedulaencargado;
	}
	public void setCedulaencargado(int cedulaencargado) {
		this.cedulaencargado = cedulaencargado;
	}
	
	public int getConsecutivomantenimiento() {
		return consecutivomantenimiento;
	}
	public void setConsecutivomantenimiento(int consecutivomantenimiento) {
		this.consecutivomantenimiento = consecutivomantenimiento;
	}
	
	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.id + ";");
        buffer.append("Piso: " + this.numeropiso + ";");
        buffer.append("Contrato: " + this.numerocontrato + ";");
        buffer.append("CC encargado: " + this.cedulaencargado);
        return buffer.toString();
    }
	
	
}
