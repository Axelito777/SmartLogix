package com.smartlogix.ms_gateway.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
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

    private static final String[] RUTAS_PUBLICAS = {
        "/api/auth/login",
        "/api/auth/registro"
    };

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        // ✅ Dejar pasar preflight CORS
        if (HttpMethod.OPTIONS.equals(exchange.getRequest().getMethod())) {
            return chain.filter(exchange);
        }

        String path = exchange.getRequest().getURI().getPath();

        for (String ruta : RUTAS_PUBLICAS) {
            if (path.equals(ruta)) {
                return chain.filter(exchange);
            }
        }

        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.replace("Bearer ", "");

        if (!jwtUtil.validarToken(token)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }
}