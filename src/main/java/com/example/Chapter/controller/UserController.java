package com.example.Chapter.controller;

import com.example.Chapter.DTO.UserLoginDTO;
import com.example.Chapter.DTO.UserRegisterDTO;
import com.example.Chapter.entity.User;
import com.example.Chapter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService us;

    @PostMapping("/register")
    public User register(@RequestBody UserRegisterDTO u){
        return us.register(u);
    }
    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO u){
        return us.login(u);
    }
}
