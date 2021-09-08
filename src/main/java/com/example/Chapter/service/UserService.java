package com.example.Chapter.service;

import com.example.Chapter.DTO.UserRegisterDTO;
import com.example.Chapter.entity.User;

public interface UserService {
    public User register(UserRegisterDTO u);
}
