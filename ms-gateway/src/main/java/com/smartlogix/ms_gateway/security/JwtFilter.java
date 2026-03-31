package com.smartlogix.ms_gateway.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtFilter implements WebFilter {

    private final JwtUtil jwtUtil;

    // Rutas publicas que no necesitan token
    private static final String[] RUTAS_PUBLICAS = {
        "/api/auth/login",
        "/api/auth/registro"
    };

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, 
                             WebFilterChain chain) {
        String path = exchange.getRequest()
                              .getURI()
                              .getPath();

        // Si es ruta publica deja pasar
        for (String ruta : RUTAS_PUBLICAS) {
            if (path.equals(ruta)) {
                return chain.filter(exchange);
            }
        }

        // Verifica que venga el token
        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // Valida el token
        String token = authHeader.replace("Bearer ", "");

        if (!jwtUtil.validarToken(token)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // Token valido, deja pasar
        return chain.filter(exchange);
    }
}