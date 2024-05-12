package com.br.b2b.service.auth;

import com.br.b2b.dto.request.AuthRequest;
import com.br.b2b.dto.response.AuthResponse;
import com.br.b2b.dto.response.UserDTO;
import com.br.b2b.model.User;
import com.br.b2b.repository.UserRepository;
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
        Optional<User> userOptional = userRepository.findByEmail(request.email());
        try {
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                boolean isSamePassword = encoder.matches(request.password(), user.getPassword());
                if (isSamePassword) {
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
                    String jwtToken = jwtService.generateToken(user);
                    userRepository.save(user);
                    UserDTO userDTO = prepareReturn(user);
                    return new AuthResponse("Usuário autenticado com sucesso!", jwtToken, true, userDTO);
                } else {
                    return new AuthResponse("Usuário ou senha inválidos!", null, false, null);
                }
            } else {
                return new AuthResponse("Usuário ou senha inválidos!", null, false, null);
            }
        } catch (AuthenticationException e) {
            return new AuthResponse("Usuário ou senha inválidos!", null, false, null);
        }
    }

    private UserDTO prepareReturn(User newUser) {
        userRepository.save(newUser);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(newUser.getId().toString());
        userDTO.setEmail(newUser.getEmail());
        userDTO.setName(newUser.getName());
        userDTO.setStatus(newUser.isStatus());
        userDTO.setCpf(newUser.getCpf());
        userDTO.setTermsConditions(newUser.getTermsConditions());
        userDTO.setCreatedAt(newUser.getCreatedAt());
        userDTO.setUpdatedAt(newUser.getUpdatedAt());
        userDTO.setEnabled(newUser.isEnabled());
        return userDTO;
    }
}