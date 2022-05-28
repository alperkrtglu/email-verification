package com.example.emailverification.user;

import com.example.emailverification.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserService userService;

    @Transactional
    public void register(User user) {
        userService.register(user);
    }
}
