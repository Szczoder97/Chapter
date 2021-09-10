package com.example.Chapter.service;

import com.example.Chapter.DTO.AddMemberToRoomDTO;
import com.example.Chapter.DTO.AddRoomDTO;
import com.example.Chapter.entity.Room;
import com.example.Chapter.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomRepo rr;
    @Override
    public void add(AddRoomDTO r) {
        rr.add(r);
    }

    @Override
    public void addMember(AddMemberToRoomDTO m) {
        rr.addMember(m);
    }
}
