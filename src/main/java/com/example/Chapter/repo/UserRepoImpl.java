package com.example.Chapter.repo;

import com.example.Chapter.entity.Book;
import com.example.Chapter.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo{
    @Autowired
    private EntityManager em;
    @Override
    public User add(User u) {
        em.persist(u);
        return u;
    }

    @Override
    public User getByEmail(String email) {
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        q.setParameter("email", email);
        return q.getSingleResult();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User update(User u) {
        return null;
    }

    @Override
    public User delete() {
        return null;
    }
}
