package com.smartlogix.ms_envios.repository;

import org.springframework.stereotype.Repository;
import com.smartlogix.ms_envios.entity.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
    // Con esto ya podemos guardar, borrar y buscar envíos sin escribir SQL
}