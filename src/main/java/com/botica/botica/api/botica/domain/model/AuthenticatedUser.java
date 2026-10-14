package com.botica.botica.api.botica.domain.model;

public record AuthenticatedUser(Long id, Role role) {
    public boolean isAdmin() {
        return role == Role.ADMIN;
    }

    public boolean isVendedor() {
        return role == Role.VENDEDOR;
    }
}
