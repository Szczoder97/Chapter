package com.example.Chapter.entity;

import javax.persistence.*;

@Entity
public class Topic {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String text;
    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
