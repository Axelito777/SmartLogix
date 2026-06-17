package com.smartlogix.ms_envios.exception;

/**
 * Excepción lanzada cuando no se encuentra un envío con el id solicitado.
 *
 * @author SmartLogix Team
 */
public class EnvioNotFoundException extends RuntimeException {
    /**
     * Crea la excepción con un mensaje que incluye el id del envío buscado.
     *
     * @param id identificador del envío que no fue encontrado
     */
    public EnvioNotFoundException(Long id) {
        super("Envío no encontrado con id: " + id);
    }
}
