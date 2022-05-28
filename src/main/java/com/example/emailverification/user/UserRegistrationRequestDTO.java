package com.example.emailverification.user;

import com.example.emailverification.user.enums.UserRole;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserRegistrationRequestDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty // valid email
    private String email;

    @NotEmpty
    private UserRole role;

}
