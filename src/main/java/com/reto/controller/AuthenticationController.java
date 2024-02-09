package com.reto.controller;


import com.reto.model.UserModel;
import com.reto.payload.AuthenticationLogin;
import com.reto.payload.AuthenticationResponse;
import com.reto.services.AuthenticationService;
import com.reto.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationLogin login) {
        logger.info("REQUEST: {}", login.toString());
        UserModel authenticatedUser = authenticationService.authenticate(login);

        logger.info("Authenticated User: {}", authenticatedUser.toString());

        String jwtToken = jwtService.generateToken(authenticatedUser);

        AuthenticationResponse loginResponse =
                AuthenticationResponse.builder()
                        .token(jwtToken)
                        .expiresIn(jwtService.getExpirationTime())
                        .build();
        return ResponseEntity.ok(loginResponse);
    }
}
