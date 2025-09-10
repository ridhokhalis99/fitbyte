package com.projectsprint_solo.fitbyte.auth.dto;

public record LoginResponse(
        String email,
        String token
) {}
