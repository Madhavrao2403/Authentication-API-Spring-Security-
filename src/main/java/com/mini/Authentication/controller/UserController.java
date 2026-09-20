package com.mini.Authentication.controller;

import com.mini.Authentication.dto.LoginRequest;
import com.mini.Authentication.dto.RegisterRequest;
import com.mini.Authentication.dto.RegisterResponse;
import com.mini.Authentication.dto.Response;
import com.mini.Authentication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody  LoginRequest request) {
        userService.login(request);
        return ResponseEntity.status(HttpStatus.OK).body(new Response(200,"Login Successful", Instant.now()));
    }
}
