package com.cest.Dao;
import com.cest.Models.Usuario;

/**
 * Conexion a base de datos Usuarios
 *
 * @author Santiago granada aguirre
 */
public class UsuarioDAO {

    /**
     * Consulta si el usuario existe en la base de datos y verifica que este
     * coincida con su respectiva contraseña
     *
     * @param usuario
     * @param password
     * @return
     */
    public Usuario ConsultarUsuario(String usuario, String password) {

        return null;
    }

    /**
     * Registrar nuevo usuario en la base de datos
     *
     * @param usuario
     */
    public void RegistrarUsuario(Usuario usuario) {

    }

    /**
     * Actualizar informacion de algun usuario
     *
     * @param usuario
     */
    public void ActualizarUsuario(Usuario usuario) {

    }

    /**
     * Elimina usuario de la base de datos
     *
     * @param usuario
     */
    public void EliminarUsuario(Usuario usuario) {
    }
}
