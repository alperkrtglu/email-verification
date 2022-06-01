package com.example.emailverification.registration.service;

import com.example.emailverification.user.entity.User;
import com.example.emailverification.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final RedisTemplate<String, String> redisTemplate;

    public void register(User user) {
        User _user = userService.register(user);
        storeEmailConfirmationTokenInRedis(_user);
    }

    private void storeEmailConfirmationTokenInRedis(User _user) {
        String token = UUID.randomUUID().toString();
        String userId = _user.getId().toString();

        redisTemplate.opsForValue().setIfAbsent(token, userId);
    }

    public void confirm(String token) {
        userService.confirm(retrieveUserIdByTokenFromRedis(token));
    }

    private Long retrieveUserIdByTokenFromRedis(String token) {
        String userId = redisTemplate.opsForValue().get(token);

        if (userId == null) {
            throw new RuntimeException("NotNull!");
        }

        return Long.parseLong(userId);
    }
}
