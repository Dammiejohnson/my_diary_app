package com.technophiles.my_diary_app_mysql.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginRequest {
    private String email;
    private String password;

}
