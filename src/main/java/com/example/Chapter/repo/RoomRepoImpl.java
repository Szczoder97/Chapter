package com.example.Chapter.repo;

import com.example.Chapter.DTO.AddMemberToRoomDTO;
import com.example.Chapter.DTO.AddRoomDTO;
import com.example.Chapter.DTO.CreateTopicDTO;
import com.example.Chapter.entity.Room;
import com.example.Chapter.entity.Topic;
import com.example.Chapter.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class RoomRepoImpl implements RoomRepo{

    @Autowired
    EntityManager em;
    @Override
    public void add(AddRoomDTO r) {
        Room room = new Room();
        room.setTitle(r.title);
        room.setBook(r.book);
        em.persist(room);

    }

    @Override
    public void addMember(AddMemberToRoomDTO m) {
        Room r = em.find(Room.class, m.roomId);
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        q.setParameter("email", m.email);
        User u = q.getSingleResult();
        r.addMember(u);
        em.persist(r);

    }

    @Override
    public void addTopic(CreateTopicDTO t) {
        Room room = t.room;
        Topic topic = new Topic();
        topic.setRoom(room);
        topic.setTitle(t.title);
        topic.setText(t.text);
        em.persist(topic);
    }

    @Override
    public Room getRoom(Long id) {
        return em.find(Room.class, id);
    }
}
