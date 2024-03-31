package com.br.b2b.dto.response;

import java.time.LocalDateTime;

public record UserResponse(String message, UserDTO result, boolean status) {

}