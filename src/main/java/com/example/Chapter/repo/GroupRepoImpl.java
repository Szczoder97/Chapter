package com.example.Chapter.repo;

import com.example.Chapter.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class GroupRepoImpl implements GroupRepo{

    @Autowired
    private EntityManager em;
    @Override
    public List<Group> findAll() {
        return em.createQuery("from Gook").getResultList();
    }

    @Override
    public Group findById(long id) {
        return em.find(Group.class, id);
    }

    @Override
    public Group add(Group g) {
        em.persist(g);
        return g;
    }

    @Override
    public Group update(Group g) {
        Group group = em.find(Group.class, g.getId());
        group.setTitle(g.getTitle());
        group.setBook(g.getBook());
        group.setActive(g.isActive());
        em.persist(group);
        return group;
    }

    @Override
    public Group remove(Group g) {
        Group group = em.find(Group.class, g.getId());
        em.remove(group);
    }
}
