package com.botica.botica.api.botica.application.port.in;

public interface RegisterUserUseCase {
    String register(String name, String email, String rawPassword);
}
