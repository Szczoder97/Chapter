package com.example.Chapter.controller;

import com.example.Chapter.DTO.AddMemberToRoomDTO;
import com.example.Chapter.DTO.AddRoomDTO;
import com.example.Chapter.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
