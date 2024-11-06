package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.dto.AuthenticationRequest;
import me.sqsw.buildandroll.dto.AuthenticationResponse;
import me.sqsw.buildandroll.dto.RegistrationRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegistrationRequest regRequest);
    AuthenticationResponse login(AuthenticationRequest authRequest);
    AuthenticationResponse createAccessToken(String refreshToken);
    AuthenticationResponse createRefreshToken(String refreshToken);
}