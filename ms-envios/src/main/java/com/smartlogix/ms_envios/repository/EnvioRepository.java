package com.smartlogix.ms_envios.repository;

import org.springframework.stereotype.Repository;

import com.smartlogix.ms_envios.model.Envio;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad {@link com.smartlogix.ms_envios.model.Envio}.
 * <p>
 * Hereda las operaciones CRUD estándar de {@link JpaRepository}.
 * </p>
 *
 * @author SmartLogix Team
 */
@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
}