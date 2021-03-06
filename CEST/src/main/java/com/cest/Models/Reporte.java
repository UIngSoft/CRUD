package com.cest.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Un reporte sobre el estado de un elemento
 */
@Entity
public class Reporte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tipoelemento;
	private LocalDate fechareporte;
	private String descripcion;
	private String argumento;
	private String estado;
	private String ubicacion;
	private String leido;
	private String notificado;
	
	public Reporte() {
		// TODO Auto-generated constructor stub
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
	 * @return the tipoelemento
	 */
	public String getTipoelemento() {
		return tipoelemento;
	}

	/**
	 * @param tipoelemento the tipoelemento to set
	 */
	public void setTipoelemento(String tipoelemento) {
		this.tipoelemento = tipoelemento;
	}

	/**
	 * @return the fechareporte
	 */
	public LocalDate getFechareporte() {
		return fechareporte;
	}

	/**
	 * @param fechareporte the fechareporte to set
	 */
	public void setFechareporte(LocalDate fechareporte) {
		this.fechareporte = fechareporte;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the argumento
	 */
	public String getArgumento() {
		return argumento;
	}

	/**
	 * @param argumento the argumento to set
	 */
	public void setArgumento(String argumento) {
		this.argumento = argumento;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the leido
	 */
	public String getLeido() {
		return leido;
	}

	/**
	 * @param leido the leido to set
	 */
	public void setLeido(String leido) {
		this.leido = leido;
	}

	/**
	 * @return the notificado
	 */
	public String getNotificado() {
		return notificado;
	}

	/**
	 * @param notificado the notificado to set
	 */
	public void setNotificado(String notificado) {
		this.notificado = notificado;
	}
	
}
