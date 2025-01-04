package sead.assignment2.auth.internal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sead.assignment2.auth.internal.dto.AuthDto;
import sead.assignment2.auth.internal.dto.AuthResponseDto;
import sead.assignment2.auth.internal.dto.RegisterRequestDto;
import sead.assignment2.auth.internal.dto.SignInRequestDto;
import sead.assignment2.auth.internal.service.InternalAuthService;

import java.net.URI;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
class AuthController {

    @Autowired
    private InternalAuthService service;

    @PostMapping("/register")
    ResponseEntity<AuthResponseDto> register( @RequestBody RegisterRequestDto dto) throws Exception {
        AuthDto authDto = service.register(dto.getEmailAddress(), dto.getPassword());
        return new ResponseEntity<>(new AuthResponseDto("User registered successfully", authDto), HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    ResponseEntity<AuthResponseDto> signIn(@RequestBody SignInRequestDto dto) throws Exception {
        AuthDto authDto = service.signIn(dto.getEmail(), dto.getPassword());
        return new ResponseEntity<>(new AuthResponseDto("User signed in successfully", authDto), HttpStatus.CREATED);
    }
}
