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

@Service
@RequiredArgsConstructor
public class EnvioService {

    private final EnvioRepository envioRepository;
    private final NotificacionesClient notificacionesClient;

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

    public List<EnvioResponse> listar() {
        return envioRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

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