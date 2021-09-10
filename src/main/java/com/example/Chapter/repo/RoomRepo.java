package com.example.Chapter.repo;

import com.example.Chapter.DTO.AddMemberToRoomDTO;
import com.example.Chapter.DTO.AddRoomDTO;
import com.example.Chapter.DTO.CreateTopicDTO;
import com.example.Chapter.entity.Room;

public interface RoomRepo {
    public void add(AddRoomDTO r);
    public void addMember(AddMemberToRoomDTO m);
    public void addTopic(CreateTopicDTO t);
    public Room getRoom(Long id);
}
