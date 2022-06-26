package com.example.emailverification.registration.controller;

import com.example.emailverification.registration.dto.RegistrationRequestDTO;
import com.example.emailverification.registration.dto.mapper.RegistrationMapper;
import com.example.emailverification.registration.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public void register(@RequestBody @Valid RegistrationRequestDTO dto) {
        registrationService.register(
                RegistrationMapper.INSTANCE.toEntity(dto)
        );
    }

    @GetMapping("confirm")
    public String confirm(@RequestParam String token) {
        registrationService.confirm(token);
        return "User Account Confirmed!";
    }
}
