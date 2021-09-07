package com.example.Chapter.repo;

import com.example.Chapter.entity.Book;

import java.util.List;

public interface BookRepo {
    public List<Book> getAll();
    public Book getBookById(Long id);
    public Book getBookByTitle(String title);
    public void removeBook(Book b);
    public Book updateBook(Book b);
    public Book saveBook(Book b);
}
