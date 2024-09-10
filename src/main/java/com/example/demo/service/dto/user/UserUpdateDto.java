package com.example.demo.service.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
    private String name;
    private String email;
    private String password;
}
