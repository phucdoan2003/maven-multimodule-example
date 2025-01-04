package sead.assignment2.internal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sead.assignment2.internal.dto.GetUserResponseDto;
import sead.assignment2.internal.service.InternalUserService;
import sead.assignment2.internal.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
class UserController {

    @Autowired
    private InternalUserService service;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    ResponseEntity<GetUserResponseDto> getUserById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(new GetUserResponseDto("User data found", service.getUserById(id)), HttpStatus.OK);
    }
}
