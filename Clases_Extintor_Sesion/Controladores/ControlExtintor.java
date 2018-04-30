/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Extintor;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author SantiagoGranadaAguirre
 */
public class ControlExtintor {

    public JdbcTemplate jdbcTemplate;

    /**
     * Consulta la informacion pertininte a un extintor con cierto identificador
     *
     * @param id Identificador de extintor
     * @return Retorna el extintor asociadoa dicho identificaor
     */
    public Extintor ConsultarExtintor(String id) {
        return null;
    }

//    public Extintor ConsultarExtintor(String ubicacion) {
//        return null;
//    } 
    /**
     * Crea un nuevo objeto de tipo extintor
     *
     * @param extintor
     */
    public void CrearExtintor(Extintor extintor) {

    }

    /**
     * Modifica un objeto o registro de tipo extintor
     *
     * @param extintor
     */
    public void ModificarExtintor(Extintor extintor) {

    }

    /**
     * Elimina el registro del extintor en la base de datos
     *
     * @param extintor
     */
    public void EliminarExtintor(Extintor extintor) {

    }

    /**
     * Valida si el id corresponde a uno existente
     *
     * @param id
     * @return
     */
    public boolean ValidarId(String id) {
        return false;
    }

    /**
     * verifica que la ubicacion coincida con el id
     *
     * @param id
     * @return
     */
    public boolean ValidarUbicacion(String id) {
        return false;
    }
}
