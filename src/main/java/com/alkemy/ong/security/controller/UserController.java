package com.alkemy.ong.security.controller;

import com.alkemy.ong.security.dto.AuthenticationRequest;
import com.alkemy.ong.security.service.UserService;
import com.alkemy.ong.security.dto.UserRequestDto;
import com.alkemy.ong.security.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody UserRequestDto user) throws Exception {
        UserResponseDto savedUser = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthenticationRequest authRequest) throws Exception {
        UserResponseDto authenticatedUser = service.authentication(authRequest);
        if(authenticatedUser != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(authenticatedUser);
        }
        else {
        return ResponseEntity.ok("ok:false");
        }
    }

}