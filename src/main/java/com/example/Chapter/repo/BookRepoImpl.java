package com.example.Chapter.repo;

import com.example.Chapter.entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookRepoImpl implements BookRepo{

    private EntityManager em;

    public BookRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Book> getAll() {
        return em.createQuery("from Book").getResultList();
    }

    @Override
    public Book getBookById(Long id) {
        return em.find(Book.class, id);
    }

    @Override
    public  Book getBookByTitle(String title){
        TypedQuery<Book> q = em.createQuery("SELECT b FROM book b WHERE b.title = :title", Book.class);
        q.setParameter("title", title);
        return q.getSingleResult();
    }

    @Override
    public Book saveBook(Book b) {
        em.persist(b);
        return b;
    }

    @Override
    public Book updateBook(Book b) {
        Book book = em.find(Book.class, b.getId());
        book.setTitle(b.getTitle());
        book.setAuthor(b.getAuthor());
        em.persist(book);
        return book;
    }

    @Override
    public void removeBook(Book b) {
        Book book = em.find(Book.class, b.getId());
        em.remove(book);
    }
}
