package com.br.b2b.resource;

import com.br.b2b.dto.response.UserResponse;
import com.br.b2b.model.User;
import com.br.b2b.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserResource {

    private final UserServiceImpl userService;

    @Autowired
    public UserResource(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody User newUser) {
        UserResponse response = userService.register(newUser);
        return ResponseEntity.ok(response);
    }
}
