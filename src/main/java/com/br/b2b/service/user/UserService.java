package com.br.b2b.service.user;

import com.br.b2b.dto.response.UserResponse;
import com.br.b2b.model.User;

public interface UserService {

    UserResponse register(User user);
}
