package com.botica.botica.api.botica.infrastructure.web;
import com.botica.botica.api.botica.application.port.in.LoginUseCase;
import com.botica.botica.api.botica.application.port.in.RegisterUserUseCase;
import com.botica.botica.api.botica.infrastructure.adapter.in.Dto.AuthResponse;
import com.botica.botica.api.botica.infrastructure.adapter.in.Dto.LoginRequest;
import com.botica.botica.api.botica.infrastructure.adapter.in.Dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final RegisterUserUseCase registerUser;
    private final LoginUseCase login;

    public AuthController(RegisterUserUseCase registerUser, LoginUseCase login) {
        this.registerUser = registerUser;
        this.login = login;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return new AuthResponse(registerUser.register(request.name(), request.email(), request.password()));
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return new AuthResponse(login.login(request.email(), request.password()));
    }
}