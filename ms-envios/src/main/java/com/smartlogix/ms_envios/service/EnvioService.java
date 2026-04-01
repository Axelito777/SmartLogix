package com.smartlogix.ms_envios.service;

import com.smartlogix.ms_envios.entity.Envio;
import com.smartlogix.ms_envios.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    // Lógica para registrar un nuevo envío
    public Envio crearEnvio(Envio envio) {
        // Al crearse, el estado inicial por defecto es PREPARANDO
        envio.setEstado("PREPARANDO");
        envio.setFechaCreacion(LocalDateTime.now());
        return envioRepository.save(envio);
    }

    // Lógica para ver todos los envíos
    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }
}