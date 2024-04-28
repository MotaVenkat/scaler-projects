package com.example.oauth.controllers;


import com.example.oauth.DTO.LoginDto;
import com.example.oauth.DTO.UserDto;
import com.example.oauth.models.Token;
import com.example.oauth.models.User;
import com.example.oauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("user/signup")
    public User signUp(@RequestBody UserDto requestDto){

    return userService.signup(requestDto.getName(),requestDto.email,requestDto.password);
    }

    @PostMapping("user/login")
    public Token login(@RequestBody LoginDto loginDto){

        return userService.login(loginDto.getEmail(),loginDto.getPassword());
    }



}
