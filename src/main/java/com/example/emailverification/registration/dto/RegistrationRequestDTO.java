package com.example.emailverification.registration.dto;

import com.example.emailverification.user.enums.UserRole;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RegistrationRequestDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @Email(regexp = ".+@.+\\..+", message = "Email not valid!")
    private String email;

    @NotNull
    private UserRole role;

}
