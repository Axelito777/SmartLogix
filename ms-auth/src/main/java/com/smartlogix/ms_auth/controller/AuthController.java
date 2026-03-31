package com.smartlogix.ms_auth.controller;

import com.smartlogix.ms_auth.dto.LoginRequest;
import com.smartlogix.ms_auth.dto.LoginResponse;
import com.smartlogix.ms_auth.model.Usuario;
import com.smartlogix.ms_auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registro(
            @RequestBody Usuario usuario) {
        authService.registro(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

    @GetMapping("/validar")
    public ResponseEntity<Boolean> validar(
            @RequestHeader("Authorization") String token) {
        String jwt = token.replace("Bearer ", "");
        return ResponseEntity.ok(authService.validarToken(jwt));
    }
}