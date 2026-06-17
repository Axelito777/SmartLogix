package com.smartlogix.ms_proveedores.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias de {@link ProveedorNotFoundException}.
 *
 * @author SmartLogix Team
 */
class ProveedorNotFoundExceptionTest {
    @Test void constructor_mensajeContieneId() {
        ProveedorNotFoundException ex = new ProveedorNotFoundException(7L);
        assertTrue(ex.getMessage().contains("7"));
        assertInstanceOf(RuntimeException.class, ex);
    }
}
