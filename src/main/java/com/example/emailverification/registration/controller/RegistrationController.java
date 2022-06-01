package com.example.emailverification.registration.controller;

import com.example.emailverification.registration.service.RegistrationService;
import com.example.emailverification.user.UserRegistrationRequestDTO;
import com.example.emailverification.user.mapper.RegisterMapper;
import com.example.emailverification.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public void register(@RequestBody UserRegistrationRequestDTO dto) {
        registrationService.register(RegisterMapper.INSTANCE.toEntity(dto));
    }

    @PostMapping("confirm")
    public void confirm(@RequestParam("token") String token) {
        registrationService.confirm(token);
    }
}
