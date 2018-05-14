package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * Un elemento que será registrado en el sistema
 */
@Entity
public class Elemento{
	
	@Id
	private int id;

	@ManyToOne
	private Piso piso;
	
	@ManyToOne
	private Contrato contrato;

	@ManyToOne
	private Encargado encargado;
	
	@ManyToOne
	private Mantenimiento mantenimiento;
	
	public Elemento() {
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the piso
	 */
	public Piso getPiso() {
		return piso;
	}

	/**
	 * @param piso the piso to set
	 */
	public void setPiso(Piso piso) {
		this.piso = piso;
	}

	/**
	 * @return the contrato
	 */
	public Contrato getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the encargado
	 */
	public Encargado getEncargado() {
		return encargado;
	}

	/**
	 * @param encargado the encargado to set
	 */
	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}

	/**
	 * @return the mantenimiento
	 */
	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}

	/**
	 * @param mantenimiento the mantenimiento to set
	 */
	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
	
	
}
