package com.botica.botica.api.botica.infrastructure.security;

import com.botica.botica.api.botica.application.port.out.CredentialsAuthenticatorPort;
import com.botica.botica.api.botica.domain.exception.InvalidCredentialsException;
import com.botica.botica.api.botica.domain.model.AuthenticatedUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class SpringCredentialsAuthenticator implements CredentialsAuthenticatorPort {

    private final AuthenticationManager authenticationManager;

    public SpringCredentialsAuthenticator(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticatedUser authenticate(String email, String rawPassword) {
        try {
            var auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, rawPassword)
            );
            return ((SecurityUser) auth.getPrincipal()).toAuthenticatedUser();
        } catch (AuthenticationException e) {
            throw new InvalidCredentialsException();
        }
    }
}
