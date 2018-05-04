package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/*
 * Un extintor que será registrado en el sistema
 */
@Entity
public class Extintor{
	/*Foreign Key*/
	@Id
	private int idelemento;
	
	@ManyToOne
	private Elemento elemento;
	
	
	@OneToOne
	private Fichatecnica fichatecnica;
	
	private String tipo;
	private int tamanio;
	private String fechainstalacion;
	private String fechaultimarecarga;
	private String fechavencimiento;
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
	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	public String getFechainstalacion() {
		return fechainstalacion;
	}
	public void setFechainstalacion(String fechainstalacion) {
		this.fechainstalacion = fechainstalacion;
	}
	public String getFechaultimarecarga() {
		return fechaultimarecarga;
	}
	public void setFechaultimarecarga(String fechaultimarecarga) {
		this.fechaultimarecarga = fechaultimarecarga;
	}
	public String getFechavencimiento() {
		return fechavencimiento;
	}
	public void setFechavencimiento(String fechavencimiento) {
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = fichatecnica.getTipo();
	}
	
	
	
}
