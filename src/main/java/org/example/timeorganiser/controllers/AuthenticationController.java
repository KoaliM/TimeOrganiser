package org.example.timeorganiser.controllers;

import dto.LoginRequest;
import dto.RegistrationRequest;
import jakarta.validation.Valid;
import org.example.timeorganiser.services.UserService;
import org.example.timeorganiser.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.preauth.j2ee.J2eeBasedPreAuthenticatedWebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {
    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegistrationRequest request){
        userService.registerUser(request);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        String jwt = JwtUtils.generateToken(loginRequest.getUsername());

        // 3. Return the token in a DTO
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
    }
