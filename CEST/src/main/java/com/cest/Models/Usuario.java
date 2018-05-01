package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	 private String encargado;
    private String user;
    private String password;
    private String tipo;
    private boolean login;

    /**
     * constructor parametrizable
     *
     * @param encargado
     * @param user
     * @param password
     * @param tipo tipo de Usuario (adinistrador, encargado, usuario comun )
     * @param login indica si el usuario se encuentra logueado
     */
    public Usuario(String encargado, String user, String password, String tipo, boolean login) {
        this.encargado = encargado;
        this.user = user;
        this.password = password;
        this.tipo = tipo;
        this.login = login;F
}
