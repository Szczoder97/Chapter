package com.example.Chapter.service;


import com.example.Chapter.DTO.UserRegisterDTO;
import com.example.Chapter.entity.User;
import com.example.Chapter.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo ur;
    private BCrypt bc = new BCrypt();

    @Transactional
    @Override
    public User register(UserRegisterDTO u) {
        User user  = new User();
        user.setEmail(u.email);
        user.setName(u.name);
        user.setPasswordSalt(BCrypt.gensalt());
        user.setPasswordHash(BCrypt.hashpw(u.password, user.getPasswordSalt()));
        return ur.add(user);
    }



}
