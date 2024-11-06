package me.sqsw.buildandroll.controller;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.TokenRequest;
import me.sqsw.buildandroll.dto.UserDto;
import me.sqsw.buildandroll.dto.request.AuthenticationRequest;
import me.sqsw.buildandroll.dto.request.RegistrationRequest;
import me.sqsw.buildandroll.dto.response.AuthenticationResponse;
import me.sqsw.buildandroll.dto.response.RoomResponse;
import me.sqsw.buildandroll.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService authenticationService;

    @GetMapping("")
    public ResponseEntity<UserDto> register() {
        return ResponseEntity.ok(new UserDto(authenticationService.getProfile()));
    }


}