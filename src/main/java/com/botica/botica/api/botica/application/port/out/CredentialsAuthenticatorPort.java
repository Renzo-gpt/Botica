package com.botica.botica.api.botica.application.port.out;

import com.botica.botica.api.botica.domain.model.AuthenticatedUser;

public interface CredentialsAuthenticatorPort {
    AuthenticatedUser authenticate(String email, String rawPassword);
}
