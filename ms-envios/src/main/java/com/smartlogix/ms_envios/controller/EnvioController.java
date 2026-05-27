package com.smartlogix.ms_envios.controller;

import com.smartlogix.ms_envios.dto.EnvioRequest;
import com.smartlogix.ms_envios.dto.EnvioResponse;
import com.smartlogix.ms_envios.service.EnvioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * Controlador REST para la gestión de envíos.
 * <p>
 * Expone los endpoints de creación y consulta de envíos bajo la ruta base {@code /api/envios}.
 * </p>
 *
 * @author SmartLogix Team
 */
@RestController
@RequestMapping("/api/envios")
@RequiredArgsConstructor
public class EnvioController {

    private final EnvioService envioService;

    /**
     * Crea un nuevo envío a partir de un pedido existente.
     *
     * @param body mapa con {@code pedido_id} (requerido) y {@code transportista} (opcional)
     * @return {@code 200 OK} con el {@link EnvioResponse} del envío creado, incluyendo el número de tracking
     */
    @PostMapping("/crear")
    public ResponseEntity<EnvioResponse> crear(@RequestBody Map<String, Object> body) {
        EnvioRequest request = new EnvioRequest();
        request.setPedidoId(body.get("pedido_id").toString());
        if (body.get("transportista") != null) {
            request.setTransportista(body.get("transportista").toString());
        }
        return ResponseEntity.ok(envioService.crear(request));
    }

    /**
     * Retorna la lista completa de envíos registrados.
     *
     * @return {@code 200 OK} con la lista de {@link EnvioResponse}
     */
    @GetMapping
    public ResponseEntity<List<EnvioResponse>> listar() {
        return ResponseEntity.ok(envioService.listar());
    }

    /**
     * Obtiene un envío por su identificador.
     *
     * @param id identificador numérico del envío
     * @return {@code 200 OK} con el {@link EnvioResponse} encontrado
     * @throws com.smartlogix.ms_envios.exception.EnvioNotFoundException si no existe el envío
     */
    @GetMapping("/{id}")
    public ResponseEntity<EnvioResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(envioService.obtener(id));
    }
}