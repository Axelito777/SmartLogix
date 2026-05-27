package com.smartlogix.ms_envios.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnvioNotFoundExceptionTest {
    @Test
    void constructor_mensajeContieneId() {
        EnvioNotFoundException ex = new EnvioNotFoundException(42L);
        assertTrue(ex.getMessage().contains("42"));
        assertInstanceOf(RuntimeException.class, ex);
    }
}
