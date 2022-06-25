package com.example.emailverification.registration.service;

import com.example.emailverification.email.EmailSender;
import com.example.emailverification.redis.RedisService;
import com.example.emailverification.user.entity.User;
import com.example.emailverification.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailSender emailSender;
    private final RedisService redisService;

    public void register(User user) {
        User _user = userService.register(user);
        String token = UUID.randomUUID().toString();

        emailSender.send(_user.getEmail(), _user.getName(), token);
        redisService.storeEmailConfirmationToken(_user, token);
    }

    public void confirm(String token) {
        userService.confirm(
                redisService.retrieveUserIdByToken(token)
        );
    }
}
