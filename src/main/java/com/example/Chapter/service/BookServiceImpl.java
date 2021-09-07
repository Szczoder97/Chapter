package com.example.Chapter.service;

import com.example.Chapter.entity.Book;
import com.example.Chapter.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo br;
    @Transactional
    @Override
    public List<Book> getAll(){
        return  br.getAll();
    }
    @Transactional
    @Override
    public  Book getBookByid(Long id){
        return br.getBookById(id);
    }
    @Transactional
    @Override
    public Book getBookByTitle(String title){
        return br.getBookByTitle(title);
    }
    @Transactional
    @Override
    public Book saveBook(Book b){
        return br.saveBook(b);
    }

    @Transactional
    @Override
    public Book updateBook(Book b) {
        return br.updateBook(b);
    }

    @Transactional
    @Override
    public void removeBook(Book b){
        br.removeBook(b);
    }

}
