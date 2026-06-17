package com.smartlogix.ms_pagos.exception;

/**
 * Excepción lanzada cuando no se encuentra un pago con el id solicitado.
 *
 * @author SmartLogix Team
 */
public class PagoNotFoundException extends RuntimeException {
    /**
     * Crea la excepción con un mensaje que incluye el id del pago buscado.
     *
     * @param id identificador del pago que no fue encontrado
     */
    public PagoNotFoundException(Long id) {
        super("Pago no encontrado con id: " + id);
    }
}
