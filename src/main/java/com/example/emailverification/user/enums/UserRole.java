package com.example.emailverification.user.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {

    ADMIN, USER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
