package com.example.Chapter.service;

import com.example.Chapter.DTO.AddMemberToRoomDTO;
import com.example.Chapter.DTO.AddRoomDTO;

public interface RoomService {
    public void add(AddRoomDTO r);
    public void addMember(AddMemberToRoomDTO m);
}
