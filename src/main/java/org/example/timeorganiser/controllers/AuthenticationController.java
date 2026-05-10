package org.example.timeorganiser.controllers;

import dto.LoginRequest;
import dto.RegistrationRequest;
import jakarta.validation.Valid;
import org.example.timeorganiser.integration.IntegrationData;
import org.example.timeorganiser.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {
    private final JwtUtils jwtUtils;

    public AuthenticationController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody RegistrationRequest request) {
        Map<String, Object> profile = IntegrationData.createUser(request.getUsername(), request.getEmail());
        String jwt = jwtUtils.generateToken(request.getUsername());
        return ResponseEntity.ok(Map.of(
                "profile", profile,
                "accessToken", jwt,
                "refreshToken", UUID.randomUUID().toString()
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        String jwt = jwtUtils.generateToken(loginRequest.getUsername());
        Map<String, Object> profile = IntegrationData.findOrCreateUser(loginRequest.getUsername());
        return ResponseEntity.ok(Map.of(
                "profile", profile,
                "accessToken", jwt,
                "refreshToken", UUID.randomUUID().toString()
        ));
    }
}
