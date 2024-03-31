package com.br.b2b.service;

import com.br.b2b.dto.request.AuthRequest;
import com.br.b2b.dto.response.AuthResponse;
import com.br.b2b.model.User;
import com.br.b2b.repository.UserRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthResponse authenticate(AuthRequest request) {
        Optional<User> user = userRepository.findByEmail(request.email());
        try {
            if (user.isPresent()) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                boolean isSamePassword = encoder.matches(request.password(), user.get().getPassword());
                if (isSamePassword) {
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
                    String jwtToken = jwtService.generateToken(user.get());
                    userRepository.save(user.get());
                    return new AuthResponse("Usuário autenticado com sucesso!", jwtToken, true);
                } else {
                    return new AuthResponse("Usuário ou senha inválidos!", null, false);
                }
            } else {
                return new AuthResponse("Usuário ou senha inválidos!", null, false);
            }
        } catch (AuthenticationException e) {
            return new AuthResponse("Usuário ou senha inválidos!", null, false);
        }
    }
}