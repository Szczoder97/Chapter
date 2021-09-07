package com.example.Chapter.service;

import com.example.Chapter.entity.Book;


import java.util.List;

public interface BookService {
    public List<Book> getAll();

    public  Book getBookByid(Long id);

    public Book getBookByTitle(String title);

    public Book saveBook(Book b);
    public Book updateBook(Book b);

    public void removeBook(Book b);
}
