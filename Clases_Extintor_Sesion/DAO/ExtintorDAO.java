/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Extintor;

/**
 * Conexion a la base de datos con Extintor
 *
 * @author Santiago granada aguirre
 */
public class ExtintorDAO {

    /**
     * permite consultar en la base de datos la existencia de un extintor
     * verificando que el identificador que ingresa coincida con alguno
     * existente en la base de datos
     *
     * @param id identificador perteneciente al extintor
     * @return Extintor que se encontro en la busqueda
     */
    public Extintor ConsultarExtintor(String id) {
        return null;
    }

    /**
     * Crea un nuevo registro de algun extintor en la base de datos
     *
     * @param extintor Extintor a ingresar
     */
    public void CrearExtintor(Extintor extintor) {

    }

    /**
     * Modifica un registro de un extintor, reemplazandolo con otro (parametro)
     *
     * @param extintor
     */
    public void ModificarExtintor(Extintor extintor) {

    }

    /**
     * Elimina un registro de un extintor, reemplazandolo con otro (parametro)
     *
     * @param extintor
     */
    public void EliminarrExtintor(Extintor extintor) {

    }
}
