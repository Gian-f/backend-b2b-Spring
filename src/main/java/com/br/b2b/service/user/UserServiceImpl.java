package com.br.b2b.service.user;

import com.br.b2b.dto.response.UserDTO;
import com.br.b2b.dto.response.UserResponse;
import com.br.b2b.model.User;
import com.br.b2b.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public static boolean validarEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public UserResponse register(User newUser) {
        if (newUser.getPassword() == null || newUser.getPassword().isEmpty()) {
            return new UserResponse("Sua senha está vazia!", null, false);
        }

        if (newUser.getEmail() == null || newUser.getEmail().isEmpty()) {
            return new UserResponse("E-mail é um campo obrigatório!", null, false);
        }

        if (!validarEmail(newUser.getEmail())) {
            return new UserResponse("E-mail inválido!", null, false);
        }

        if (newUser.getCpf() == null || newUser.getCpf().isEmpty()) {
            return new UserResponse("CPF é um campo obrigatório!", null, false);
        }

        if (userRepository.existsByCpf(newUser.getCpf())) {
            return new UserResponse("CPF já existe!", null, false);
        }

        if (!Objects.equals(newUser.getPassword(), newUser.getConfirmPassword())) {
            return new UserResponse("As senhas não coincidem!", null, false);
        }

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setConfirmPassword(passwordEncoder.encode(newUser.getConfirmPassword()));

        UserDTO userDTO = prepareReturn(newUser);

        return new UserResponse("Usuário criado com sucesso!", userDTO, true);
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