package com.smartlogix.ms_auth.service;

import com.smartlogix.ms_auth.dto.LoginRequest;
import com.smartlogix.ms_auth.dto.LoginResponse;
import com.smartlogix.ms_auth.model.Usuario;
import com.smartlogix.ms_auth.repository.UsuarioRepository;
import com.smartlogix.ms_auth.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository
            .findByEmail(request.getEmail())
            .orElseThrow(() -> 
                new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(
                request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtUtil.generarToken(
            usuario.getEmail(), usuario.getRol());

        return new LoginResponse(token, usuario.getRol(), 
            usuario.getEmail());
    }

    public void registro(Usuario usuario) {
        usuario.setPassword(
            passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }

    public boolean validarToken(String token) {
        return jwtUtil.validarToken(token);
    }
}