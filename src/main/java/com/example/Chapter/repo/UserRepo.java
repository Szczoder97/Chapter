package com.example.Chapter.repo;

import com.example.Chapter.entity.User;

import java.util.List;

public interface UserRepo {
    public User add(User u);
    public User getByEmail(String email);
    public List<User> getAll();
    public User update(User u);
    public User delete();
}
