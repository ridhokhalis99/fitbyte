package com.projectsprint_solo.fitbyte.auth.controller;

import com.projectsprint_solo.fitbyte.auth.AuthService;
import com.projectsprint_solo.fitbyte.auth.dto.LoginRequest;
import com.projectsprint_solo.fitbyte.auth.dto.LoginResponse;
import com.projectsprint_solo.fitbyte.auth.dto.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponse register(@Valid @RequestBody RegisterRequest req) {
        return authService.register(req);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest req) {
        return authService.login(req);
    }
}
