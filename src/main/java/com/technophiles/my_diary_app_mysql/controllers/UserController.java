package com.technophiles.my_diary_app_mysql.controllers;


import com.technophiles.my_diary_app_mysql.dtos.UserDto;
import com.technophiles.my_diary_app_mysql.dtos.responses.ApiResponse;
import com.technophiles.my_diary_app_mysql.exceptions.DiaryApplicationException;
import com.technophiles.my_diary_app_mysql.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v3/diaryApp")
public class UserController {

    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/login")
    public String login(){
        return "Welcome to diary application";
    }

    @PostMapping("/users/create")
    public ResponseEntity<?> createUser(@RequestParam @Valid @NotNull @NotBlank String email,
                                        @RequestParam @Valid @NotNull String password) throws DiaryApplicationException {
//        try {
        password = bCryptPasswordEncoder.encode(password);
            UserDto userDto = userService.createAccount(email, password);
            ApiResponse apiResponse = ApiResponse.builder()
                    .payload(userDto)
                    .isSuccessful(true)
                    .statusCode(201)
                    .message("user created successfully")
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
//        } catch (DiaryApplicationException e) {
//            ApiResponse apiResponse = ApiResponse.builder()
//                    .payload(null)
//                    .isSuccessful(false)
//                    .statusCode(400)
//                    .message(e.getMessage())
//                    .build();
//            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
//        }
    }
}
