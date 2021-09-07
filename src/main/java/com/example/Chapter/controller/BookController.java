package com.example.Chapter.controller;

import com.example.Chapter.entity.Book;
import com.example.Chapter.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bs;

    @GetMapping()
    public List<Book> getAll(){
        return bs.getAll();
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return bs.getBookByid(id);
    }
   /* @GetMapping("/{title}")
    public Book getBook(@PathVariable String title){
        return bs.getBookByTitle(title);
    }*/
    @PostMapping
    public Book saveBook(@RequestBody Book b){
        return bs.saveBook(b);
    }
    @PutMapping 
    public Book updateBook(@RequestBody Book b){
        return bs.updateBook(b);
    }
    @DeleteMapping
    public void removeBook(@RequestBody Book b){
        bs.removeBook(b);
    }
}
