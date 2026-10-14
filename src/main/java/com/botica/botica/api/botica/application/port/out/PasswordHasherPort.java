package com.botica.botica.api.botica.application.port.out;

public interface PasswordHasherPort {
    String hash(String rawPassword);
}
