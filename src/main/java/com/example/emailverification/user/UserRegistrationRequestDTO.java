package com.example.emailverification.user;

import lombok.Data;

@Data
public class UserRegistrationRequestDTO {

    private String name;
    private String username;
    private String password;
    private String email;

}
