package com.example.emailverification.user.service;

import com.example.emailverification.user.entity.User;
import com.example.emailverification.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User register(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void confirm(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Not Found User"));
        user.enable();
    }
}
