package com.botica.botica.api.botica.application.port.out;

import com.botica.botica.api.botica.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    boolean existsByEmail(String email);
    User save(User user);
    Optional<User> findByEmail(String email);
}
