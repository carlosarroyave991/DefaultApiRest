package com.Prueba1.cine.Errors;

/**@author Carlos Arroyave
 * Se utiliza para generar mensajes a la hora de tener una excepcion
 */
public class DefaultException extends RuntimeException{
    private static final Long serialVerionUID = 1L;

    public DefaultException(String mensaje){
        super(mensaje);
    }
}
