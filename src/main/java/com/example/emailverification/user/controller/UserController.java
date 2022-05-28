package com.example.emailverification.user.controller;

import com.example.emailverification.user.RegistrationService;
import com.example.emailverification.user.UserRegistrationRequestDTO;
import com.example.emailverification.user.mapper.RegisterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class UserController {

    private final RegistrationService registrationService;

    @PostMapping
    public void register(@RequestBody UserRegistrationRequestDTO dto) {
        registrationService.register(RegisterMapper.INSTANCE.toEntity(dto));
    }
}
