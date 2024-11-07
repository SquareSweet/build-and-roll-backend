package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.dto.request.AuthenticationRequest;
import me.sqsw.buildandroll.dto.response.AuthenticationResponse;
import me.sqsw.buildandroll.dto.request.RegistrationRequest;
import me.sqsw.buildandroll.model.User;

public interface AuthenticationService {
    AuthenticationResponse register(RegistrationRequest regRequest);
    AuthenticationResponse login(AuthenticationRequest authRequest);
    AuthenticationResponse createAccessToken(String refreshToken);
    AuthenticationResponse createRefreshToken(String refreshToken);
    User getProfile();
}