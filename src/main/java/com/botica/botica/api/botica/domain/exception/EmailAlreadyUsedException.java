package com.botica.botica.api.botica.domain.exception;

public class EmailAlreadyUsedException extends RuntimeException {
    public EmailAlreadyUsedException(String email) {
        super("The customer with email " + email + " already existis.");
    }
}
