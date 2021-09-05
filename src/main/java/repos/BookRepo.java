package repos;

import entity.Book;
import entity.IBookRepo;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookRepo implements IBookRepo {
    private final EntityManager _entityManager;

    @Autowired
    public BookRepo(EntityManager entityManager){
        _entityManager = entityManager;
    }
    @Override
    @Transactional
    public List<Book> findAll() {
        Session s = _entityManager.unwrap(Session.class);
        Query<Book> q = s.createQuery("from Books", Book.class);
        List<Book> response = q.getResultList();
        return response;
    }
}
