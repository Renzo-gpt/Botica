package com.botica.botica.api.botica.application.service;

import com.botica.botica.api.botica.application.port.in.LoginUseCase;
import com.botica.botica.api.botica.application.port.in.RegisterUserUseCase;
import com.botica.botica.api.botica.application.port.out.CredentialsAuthenticatorPort;
import com.botica.botica.api.botica.application.port.out.PasswordHasherPort;
import com.botica.botica.api.botica.application.port.out.TokenIssuerPort;
import com.botica.botica.api.botica.application.port.out.UserRepositoryPort;
import com.botica.botica.api.botica.domain.exception.EmailAlreadyUsedException;
import com.botica.botica.api.botica.domain.model.AuthenticatedUser;
import com.botica.botica.api.botica.domain.model.Role;
import com.botica.botica.api.botica.domain.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService implements LoginUseCase, RegisterUserUseCase {

    private final UserRepositoryPort users;
    private final PasswordHasherPort passwordHasher;
    private final CredentialsAuthenticatorPort authenticator;
    private final TokenIssuerPort tokenIssuer;

    public AuthService(UserRepositoryPort users,
                       PasswordHasherPort passwordHasher,
                       CredentialsAuthenticatorPort authenticator,
                       TokenIssuerPort tokenIssuer){

        this.users = users;
        this.passwordHasher = passwordHasher;
        this.authenticator = authenticator;
        this.tokenIssuer = tokenIssuer;
    }

    @Override
    public String login(String email, String rawPassword) {
        AuthenticatedUser user = authenticator.authenticate(email, rawPassword);
        return tokenIssuer.issue(email, user.role());
    }

    @Override
    @Transactional
    public String register(String name, String email, String rawPassword) {
        if (users.existsByEmail(email)) {
            throw new EmailAlreadyUsedException(email);
        }

        Role assignedRole = determineRoleByEmail(email);

        User saved = users.save(User.register(
                name,
                email,
                passwordHasher.hash(rawPassword),
                assignedRole
        ));

        return tokenIssuer.issue(saved.getEmail(), saved.getRole());

    }
    private Role determineRoleByEmail(String email) {
        String cleanEmail = email.trim().toLowerCase();

        if (cleanEmail.endsWith("@botica.com")) {
            return Role.ADMIN;
        }

        return Role.VENDEDOR;
    }
}
