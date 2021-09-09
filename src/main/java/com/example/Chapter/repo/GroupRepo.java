package com.example.Chapter.repo;

import com.example.Chapter.entity.Group;

import java.util.List;

public interface GroupRepo {
    public List<Group> findAll();
    public Group findById(long id);
    public Group add(Group g);
    public Group update(Group g);
    public Group remove(Group g);
}
