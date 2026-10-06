package com.botica.botica.api.botica.infrastructure.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public record LoginRequestDto(String username, String password) {}
    public record TokenResponseDto(String token, String tokenType, long expiresIn) {}

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthController(
            TokenService tokenService,
            AuthenticationManager authenticationManager
    ) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody LoginRequestDto requestDto) {
        Authentication auth = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(
                        requestDto.username(), requestDto.password()
                ));

        // 1800 segundos = 30 minutos de vigencia
        return new TokenResponseDto(tokenService.generate(auth), "Bearer", 600);
    }
}