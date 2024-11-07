package me.sqsw.buildandroll.controller;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.request.AuthenticationRequest;
import me.sqsw.buildandroll.dto.response.AuthenticationResponse;
import me.sqsw.buildandroll.dto.request.RegistrationRequest;
import me.sqsw.buildandroll.dto.TokenRequest;
import me.sqsw.buildandroll.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody RegistrationRequest regRequest) {
        return authenticationService.register(regRequest);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authRequest) {
        return authenticationService.login(authRequest);
    }

    @PostMapping("/token")
    public AuthenticationResponse createAccessToken(@RequestBody TokenRequest authRequest) {
        return authenticationService.createAccessToken(authRequest.getRefreshToken());
    }

    @PostMapping("/refresh")
    public AuthenticationResponse createRefreshToken(@RequestBody TokenRequest authRequest) {
        return authenticationService.createRefreshToken(authRequest.getRefreshToken());
    }
}