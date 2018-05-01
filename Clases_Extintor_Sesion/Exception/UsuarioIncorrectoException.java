/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author USER
 */
public class UsuarioIncorrectoException extends Exception {

    /**
     * Creates a new instance of <code>UsuarioIncorrectoException</code> without
     * detail message.
     */
    public UsuarioIncorrectoException() {
    }

    /**
     * Constructs an instance of <code>UsuarioIncorrectoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public UsuarioIncorrectoException(String msg) {
        super(msg);
    }
}
