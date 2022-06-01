package com.example.emailverification.registration.service;

import com.example.emailverification.user.entity.User;
import com.example.emailverification.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final RedisTemplate<String, String> redisTemplate;

    public void register(User user) {
        User _user = userService.register(user);

        String token = UUID.randomUUID().toString();
        String userId = _user.getId().toString();

        redisTemplate.opsForValue().setIfAbsent(token, userId);
    }

    @Transactional
    public void confirm(String token) {
        Long userId = Long.parseLong(Objects.requireNonNull(redisTemplate.opsForValue().get(token)));
        userService.confirm(userId);
    }
}
