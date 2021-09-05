package controllers;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repos.BookRepo;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepo _bookRepo;

    @Autowired
    public BookController(BookRepo bookRepo){
        _bookRepo = bookRepo;
    }

    @GetMapping()
    public List<Book> findAll(){
        return _bookRepo.findAll();
    }
}