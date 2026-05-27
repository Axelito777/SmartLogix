package com.smartlogix.ms_pagos.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PagoNotFoundExceptionTest {
    @Test void constructor_mensajeContieneId() {
        PagoNotFoundException ex = new PagoNotFoundException(5L);
        assertTrue(ex.getMessage().contains("5"));
        assertInstanceOf(RuntimeException.class, ex);
    }
}
