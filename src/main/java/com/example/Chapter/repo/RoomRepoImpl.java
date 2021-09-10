package com.example.Chapter.repo;

import com.example.Chapter.DTO.AddMemberToRoomDTO;
import com.example.Chapter.DTO.AddRoomDTO;
import com.example.Chapter.entity.Room;
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
}
