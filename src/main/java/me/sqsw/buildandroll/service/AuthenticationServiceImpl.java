package me.sqsw.buildandroll.service;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sqsw.buildandroll.dto.request.AuthenticationRequest;
import me.sqsw.buildandroll.dto.response.AuthenticationResponse;
import me.sqsw.buildandroll.dto.request.RegistrationRequest;
import me.sqsw.buildandroll.exception.InvalidTokenException;
import me.sqsw.buildandroll.model.User;
import me.sqsw.buildandroll.utils.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserDetailsService userDetailsService;
    private final UserService userService;
    private final JwtTokenUtils tokenUtils;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegistrationRequest regRequest) {
        if (regRequest.getUsername() == null || regRequest.getUsername().isEmpty() ||
                regRequest.getPassword() == null || regRequest.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Login and password should not be empty");
        }
        String hashedPassword = passwordEncoder.encode(regRequest.getPassword());
        User user = new User(
                null,
                regRequest.getUsername(),
                hashedPassword,
                null
        );
        user = userService.create(user);
        log.debug("Created user id: {}, username: {}", user.getId(), user.getUsername());

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        String accessToken = tokenUtils.generateAccessToken(userDetails);
        String refreshToken = tokenUtils.generateRefreshToken(userDetails);
        return new AuthenticationResponse(accessToken, refreshToken);
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        String accessToken = tokenUtils.generateAccessToken(userDetails);
        String refreshToken = tokenUtils.generateRefreshToken(userDetails);
        return new AuthenticationResponse(accessToken, refreshToken);
    }

    public User getProfile(){
        String userName = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Optional<User> user = userService.getByUsername(userName);
        return user.get();
    }

    @Override
    public AuthenticationResponse createAccessToken(String refreshToken) {
        if (tokenUtils.validateRefreshToken(refreshToken)) {
            Claims claims = tokenUtils.getRefreshClaims(refreshToken);
            UserDetails userDetails = userDetailsService.loadUserByUsername(claims.getSubject());
            String accessToken = tokenUtils.generateAccessToken(userDetails);
            return new AuthenticationResponse(accessToken, null);
        }
        throw new InvalidTokenException("Invalid refresh token");
    }

    @Override
    public AuthenticationResponse createRefreshToken(String refreshToken) {
        if (tokenUtils.validateRefreshToken(refreshToken)) {
            final Claims claims = tokenUtils.getRefreshClaims(refreshToken);
            UserDetails userDetails = userDetailsService.loadUserByUsername(claims.getSubject());
            String accessToken = tokenUtils.generateAccessToken(userDetails);
            String newRefreshToken = tokenUtils.generateRefreshToken(userDetails);
            return new AuthenticationResponse(accessToken, newRefreshToken);
        }
        throw new InvalidTokenException("Invalid refresh token");
    }
}