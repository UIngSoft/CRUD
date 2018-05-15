package com.cest.Models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * Un extintor que será registrado en el sistema
 */
@Entity
public class Extintor{
	/*Foreign Key*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idelemento;
	
	/*Llave foranea a elemento*/
	@ManyToOne
	private Elemento elemento;
	
	/*Llave foranea a ficha tecnica*/
	@OneToOne
	private Fichatecnica fichatecnica;
	
	
	private String tamanio;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private LocalDate fechaultimarecarga;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private LocalDate fechavencimiento;
	private String estado;
	private int caducidadanios;
	
	public int getIdelemento() {
		return idelemento;
	}
	public void setIdelemento(int idelemento) {
		this.idelemento = idelemento;
	}
	public Elemento getElemento() {
		return elemento;
	}
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}
	public Fichatecnica getFichatecnica() {
		return fichatecnica;
	}
	public void setFichatecnica(Fichatecnica fichatecnica) {
		this.fichatecnica = fichatecnica;
	}
	public String getTamanio() {
		return tamanio;
	}
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
	public LocalDate getFechaultimarecarga() {
		return fechaultimarecarga;
	}
	public void setFechaultimarecarga(LocalDate fechaultimarecarga) {
		this.fechaultimarecarga = fechaultimarecarga;
	}
	public LocalDate getFechavencimiento() {
		return fechavencimiento;
	}
	public void setFechavencimiento(LocalDate fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCaducidadanios() {
		return caducidadanios;
	}
	public void setCaducidadanios(int caducidadanios) {
		this.caducidadanios = caducidadanios;
	}
	
}
