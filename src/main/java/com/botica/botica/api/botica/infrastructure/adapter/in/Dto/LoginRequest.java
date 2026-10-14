package com.botica.botica.api.botica.infrastructure.adapter.in.Dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank String email, @NotBlank String password) {
}