/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class Extintor {
    private String id;
    private String tipo;
    private String tamaño;
    private String ubicacion;
    private LocalDate fechaUltimaRecarga;
    private LocalDate fechaProximaRecarga;
    private String caducidad;
    private float encargado;
    private String estado;
    private String nitEmpresa;

    public Extintor(String id, String tipo, String tamaño, String ubicacion, LocalDate fechaUltimaRecarga, LocalDate fechaProximaRecarga, String caducidad, float encargado, String estado, String nitEmpresa) {
        this.id = id;
        this.tipo = tipo;
        this.tamaño = tamaño;
        this.ubicacion = ubicacion;
        this.fechaUltimaRecarga = fechaUltimaRecarga;
        this.fechaProximaRecarga = fechaProximaRecarga;
        this.caducidad = caducidad;
        this.encargado = encargado;
        this.estado = estado;
        this.nitEmpresa = nitEmpresa;
    }
    
           
    
}
