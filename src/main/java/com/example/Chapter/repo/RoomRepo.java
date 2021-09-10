package com.example.Chapter.repo;

import com.example.Chapter.DTO.AddMemberToRoomDTO;
import com.example.Chapter.DTO.AddRoomDTO;

public interface RoomRepo {
    public void add(AddRoomDTO r);
    public void addMember(AddMemberToRoomDTO m);
}
