package com.example.Chapter.service;


import com.example.Chapter.DTO.GetUserDTO;
import com.example.Chapter.DTO.UserLoginDTO;
import com.example.Chapter.DTO.UserRegisterDTO;
import com.example.Chapter.entity.User;
import com.example.Chapter.repo.UserRepo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

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

    @Override
    public String login(UserLoginDTO u) {
        User user = ur.getByEmail(u.email);
        if(BCrypt.checkpw(u.password, user.getPasswordHash())){
            return generateToken(user);
        }else{
            return "Email or  password are invalid!";
        }
    }

    @Override
    public GetUserDTO getByEmail(String email) {
        GetUserDTO u = new GetUserDTO();
        User user = ur.getByEmail(email);
        u.id = user.getId();
        u.name = user.getName();
        u.email = user.getEmail();
        return u;
    }

    @Override
    public GetUserDTO getById(Long id) {
        return null;
    }

    private String generateToken(User u){
        long currentTime = System.currentTimeMillis();
        JwtBuilder token = Jwts.builder()
                .setSubject(u.getName())
                .claim("role", u.getRole())
                .claim("id", u.getId())
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime + 900000))
                .signWith(SignatureAlgorithm.HS256, "123veryH@rd2Gue$$321");
        return token.compact();
    }


}
