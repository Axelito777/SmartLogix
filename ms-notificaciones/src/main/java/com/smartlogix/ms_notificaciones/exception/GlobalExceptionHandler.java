package com.smartlogix.ms_notificaciones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

/**
 * Manejador global de excepciones del microservicio de notificaciones.
 *
 * @author SmartLogix Team
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Captura {@link NotificacionNotFoundException} y la convierte en una
     * respuesta HTTP 404 con el mensaje de error.
     *
     * @param ex excepción lanzada cuando no se encuentra la notificación solicitada
     * @return respuesta con estado 404 y el mensaje de error
     */
    @ExceptionHandler(NotificacionNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(NotificacionNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Captura los errores de validación de Bean Validation y los convierte
     * en una respuesta HTTP 400 con un mapa campo→mensaje.
     *
     * @param ex excepción lanzada por Spring al fallar la validación del request body
     * @return respuesta con estado 400 y los errores de validación por campo
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}