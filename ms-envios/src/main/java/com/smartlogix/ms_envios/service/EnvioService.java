package com.smartlogix.ms_envios.service;

import com.smartlogix.ms_envios.client.NotificacionesClient;
import com.smartlogix.ms_envios.dto.EnvioRequest;
import com.smartlogix.ms_envios.dto.EnvioResponse;
import com.smartlogix.ms_envios.exception.EnvioNotFoundException;
import com.smartlogix.ms_envios.model.Envio;
import com.smartlogix.ms_envios.repository.EnvioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Servicio de negocio para la gestión de envíos.
 * <p>
 * Crea envíos con número de tracking generado automáticamente, persiste su estado
 * y notifica al cliente vía {@code ms-notificaciones}. Los fallos de notificación
 * se ignoran para no bloquear la operación principal.
 * </p>
 *
 * @author SmartLogix Team
 */
@Service
@RequiredArgsConstructor
public class EnvioService {

    private final EnvioRepository envioRepository;
    private final NotificacionesClient notificacionesClient;

    /**
     * Crea un nuevo envío en estado {@code PREPARANDO} con tracking generado.
     * <p>
     * Intenta enviar una notificación al cliente; si falla, la operación continúa igualmente.
     * </p>
     *
     * @param request datos del envío con el {@code pedidoId} y el transportista
     * @return {@link EnvioResponse} con el tracking number y estado inicial del envío
     */
    public EnvioResponse crear(EnvioRequest request) {
        Envio envio = new Envio();
        envio.setPedidoId(request.getPedidoId());
        envio.setTransportista(request.getTransportista());
        envio.setTrackingNumber(UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        envio.setEstado("PREPARANDO");
        envioRepository.save(envio);

        try {
            Map<String, Object> notificacion = new HashMap<>();
            notificacion.put("usuarioId", request.getPedidoId());
            notificacion.put("mensaje", "Tu envío fue creado con tracking: " + envio.getTrackingNumber());
            notificacionesClient.enviarNotificacion(notificacion);
        } catch (Exception ignored) {}

        return convertirAResponse(envio);
    }

    /**
     * Retorna la lista de todos los envíos registrados.
     *
     * @return lista de {@link EnvioResponse}; vacía si no hay envíos
     */
    public List<EnvioResponse> listar() {
        return envioRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un envío por su identificador.
     *
     * @param id identificador numérico del envío
     * @return {@link EnvioResponse} con los datos del envío
     * @throws com.smartlogix.ms_envios.exception.EnvioNotFoundException si no existe el envío
     */
    public EnvioResponse obtener(Long id) {
        Envio envio = envioRepository.findById(id)
                .orElseThrow(() -> new EnvioNotFoundException(id));
        return convertirAResponse(envio);
    }

    private EnvioResponse convertirAResponse(Envio e) {
        return new EnvioResponse(e.getId(), e.getPedidoId(), e.getTrackingNumber(),
                e.getEstado(), e.getTransportista(), e.getFechaCreacion());
    }
}