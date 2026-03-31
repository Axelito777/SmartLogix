package com.smartlogix.ms_auth.repository;

import com.smartlogix.ms_auth.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository 
    extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}