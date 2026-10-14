package com.botica.botica.api.botica.application.port.out;

import com.botica.botica.api.botica.domain.model.Role;

public interface TokenIssuerPort {
    String issue(String email, Role role);
}
