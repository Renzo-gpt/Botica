package com.botica.botica.api.botica.infrastructure.security;

import com.botica.botica.api.botica.application.port.out.UserRepositoryPort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private final UserRepositoryPort users;

    public CustomUserDetailsService(UserRepositoryPort users) {
        this.users = users;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return users.findByEmail(email)
                .map(SecurityUser::toSecurityUserFromDomain)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario con email: " + email + " no encontrado."));
    }
}
