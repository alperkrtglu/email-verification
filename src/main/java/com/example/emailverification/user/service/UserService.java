package com.example.emailverification.user.service;

import com.example.emailverification.user.User;
import com.example.emailverification.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void register(User user) {
        userRepository.save(user);
    }
}
