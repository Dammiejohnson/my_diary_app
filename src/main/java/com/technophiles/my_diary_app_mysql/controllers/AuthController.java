package com.technophiles.my_diary_app_mysql.controllers;

import com.technophiles.my_diary_app_mysql.dtos.LoginRequest;
import com.technophiles.my_diary_app_mysql.dtos.responses.AuthToken;
import com.technophiles.my_diary_app_mysql.models.User;
import com.technophiles.my_diary_app_mysql.security.jwt.TokenProvider;
import com.technophiles.my_diary_app_mysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/diaryApp/auth")
public class AuthController {

    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateJWTToken(authentication);
        User user = userService.findUserByEmail(loginRequest.getEmail());
         return new ResponseEntity<>(new AuthToken(token, user.getId()), HttpStatus.OK);
    }
}
