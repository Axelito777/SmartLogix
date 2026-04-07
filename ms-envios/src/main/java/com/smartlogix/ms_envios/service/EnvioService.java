package com.smartlogix.ms_envios.service;

import com.smartlogix.ms_envios.model.Envio;
import com.smartlogix.ms_envios.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository repository;

    public Optional<Envio> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Envio crearEnvio(Envio envio) {
        envio.setFechaCreacion(LocalDateTime.now());
        envio.setEstado("EN_PREPARACION");
        // Generamos un número de tracking aleatorio básico
        envio.setNumeroTracking("TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        return repository.save(envio);
    }

    public String obtenerTracking(Long id) {
        return repository.findById(id)
                .map(envio -> "El envío con tracking " + envio.getNumeroTracking() + " está actualmente: " + envio.getEstado())
                .orElse("Envío no encontrado");
    }
}