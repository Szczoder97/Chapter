package com.example.Chapter.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @OneToOne
    @JoinColumn(name = "bookId")
    private Book book;
    @ManyToMany
    @JoinTable(name = "ROOMS_MEMBERS")
    private List<User> members;

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public List<User> getMembers() {
        return members;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public void addMember(User u){
        members.add(u);
    }
    public void removeMember(User u){
        members.remove(u);
    }
}
