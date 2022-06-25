package com.example.emailverification.registration.controller;

import com.example.emailverification.registration.dto.RegistrationRequestDTO;
import com.example.emailverification.registration.dto.mapper.RegistrationMapper;
import com.example.emailverification.registration.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public void register(@RequestBody RegistrationRequestDTO dto) {
        registrationService.register(
                RegistrationMapper.INSTANCE.toEntity(dto)
        );
    }

    @GetMapping("confirm")
    public void confirm(@RequestParam String token) {
        registrationService.confirm(token);
    }
}
