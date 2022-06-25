package com.example.emailverification.redis;

import com.example.emailverification.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RedisService {

    @Value("${spring.redis.expiration_time}")
    private Long EXPIRATION_TIME;

    private final StringRedisTemplate redisTemplate;

    public void storeEmailConfirmationToken(User _user, String token) {
        redisTemplate.opsForValue().setIfAbsent(token, _user.getId().toString(), EXPIRATION_TIME, TimeUnit.MINUTES);
    }

    public Long retrieveUserIdByToken(String token) {
        String userId = redisTemplate.opsForValue().get(token);

        if (userId == null) {
            throw new RuntimeException("Not Null!");
        }

        return Long.parseLong(userId);
    }
}
