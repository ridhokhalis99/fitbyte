package com.projectsprint_solo.fitbyte.auth;

import com.projectsprint_solo.fitbyte.auth.dto.LoginRequest;
import com.projectsprint_solo.fitbyte.auth.dto.LoginResponse;
import com.projectsprint_solo.fitbyte.auth.dto.RegisterRequest;
import com.projectsprint_solo.fitbyte.common.jwt.JwtUtil;
import com.projectsprint_solo.fitbyte.user.UserEntity;
import com.projectsprint_solo.fitbyte.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public LoginResponse register(RegisterRequest req) {
        String email = normalize(req.email());
        if (userRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }
        UserEntity u = new UserEntity();
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(req.password()));
        userRepository.save(u);

        String token = jwtUtil.generateToken(email);
        return new LoginResponse(email, token);
    }

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest req) {
        String email = normalize(req.email());
        UserEntity u = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Email not found"));

        if (!passwordEncoder.matches(req.password(), u.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password");
        }

        String token = jwtUtil.generateToken(email);
        return new LoginResponse(email, token);
    }

    private String normalize(String email) {
        return email == null ? null : email.trim().toLowerCase();
    }
}
