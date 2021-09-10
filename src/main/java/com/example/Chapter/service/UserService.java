package com.example.Chapter.service;

import com.example.Chapter.DTO.GetUserDTO;
import com.example.Chapter.DTO.UserLoginDTO;
import com.example.Chapter.DTO.UserRegisterDTO;
import com.example.Chapter.entity.User;

public interface UserService {
    public User register(UserRegisterDTO u);
    public String login(UserLoginDTO u);
    public GetUserDTO getByEmail(String email);
    public GetUserDTO getById(Long id);
}
