package com.example.Chapter.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Group {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @OneToOne
    private Book book;
    @OneToOne
    private User moderator;
    @ManyToMany
    private List<User> members = null;
    private boolean isActive = true;

    public Group() {
    }

    public Group(String title, Book book, User moderator) {
        this.title = title;
        this.book = book;
        this.moderator = moderator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public User getModerator() {
        return moderator;
    }

    public void setModerator(User moderator) {
        this.moderator = moderator;
    }

    public List<User> getMembers() {
        return members;
    }

    public void addMember(User u){
        members.add(u);
    }

    public void removeMember(User u){
        members.remove(u);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Group{" +
                "title='" + title + '\'' +
                ", book=" + book +
                '}';
    }
}
