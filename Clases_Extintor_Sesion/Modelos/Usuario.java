/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 * Longin Usuarios
 *
 * @author Santiago granada aguirre
 */
public class Usuario {

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
        this.login = login;
    }

}
