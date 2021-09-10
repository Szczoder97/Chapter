package com.example.Chapter.controller;

import com.example.Chapter.DTO.AddMemberToRoomDTO;
import com.example.Chapter.DTO.AddRoomDTO;
import com.example.Chapter.DTO.CreateTopicDTO;
import com.example.Chapter.entity.Room;
import com.example.Chapter.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService rs;

    @PostMapping
    public void addRoom(@RequestBody AddRoomDTO r){
        rs.add(r);
    }
    @PostMapping("/members")
    public void addMember(@RequestBody AddMemberToRoomDTO m){
        rs.addMember(m);
    }
    @GetMapping("/{id}")
    public Room getRoom(@PathVariable Long id){
        return rs.getRoom(id);
    }
    @PostMapping("/{id}")
    public void createTopic(@RequestBody CreateTopicDTO t, @PathVariable Long id){
        Room r = rs.getRoom(id);
        t.room = r;
        rs.addTopic(t);
    }

}
