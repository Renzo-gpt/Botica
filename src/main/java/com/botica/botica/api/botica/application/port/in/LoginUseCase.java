package com.botica.botica.api.botica.application.port.in;

public interface LoginUseCase {
    String login(String email, String rawPassword);
}
