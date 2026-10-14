package com.botica.botica.api.botica.infrastructure.security;

import com.botica.botica.api.botica.application.port.out.TokenIssuerPort;
import com.botica.botica.api.botica.domain.model.Role;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenIssuer implements TokenIssuerPort {

    private final JwtService jwtService;

    public JwtTokenIssuer(JwtService jwtService){
        this.jwtService = jwtService;
    }

    @Override
    public String issue(String email, Role role) {
        return jwtService.generateToken(email, role);
    }
}
