package com.cest.Models;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Botiquin extends Elemento{
	/*Foreign Key*/
	private int idelemento;
	
	private int numerorecibdo;
	private LocalDate fechavencimiento;
	private String esparadrapo;
	private int cantidadesparadrapo;
	private LocalDate fechavencimientoesparadrapo;
	private String tapabocas;
	private String parcheocular;
	private String vendaalgodon;
	private String curaestandar;
	private String alcoholantiseptico;
	private String linterna;
	private String algodon;
	private String pito;
	private String solucionsalina;
	private String termometro;
	private String solucionyodada;
	private String saleshidratantes;
}
