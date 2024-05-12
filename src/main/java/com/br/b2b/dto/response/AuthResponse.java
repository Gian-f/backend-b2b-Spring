package com.br.b2b.dto.response;


import com.br.b2b.model.User;

public record AuthResponse(String message, String result, boolean status, UserDTO user) {

}

