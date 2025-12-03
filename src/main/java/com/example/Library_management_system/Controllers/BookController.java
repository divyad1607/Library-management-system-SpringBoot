package com.example.Library_management_system.Controllers;

import com.example.Library_management_system.Entities.Book;
import com.example.Library_management_system.Services.BookService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.util.ArrayBuilders;

@RequestMapping
@RestController("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("add")
    public String addBook(@RequestBody Book book){

        String result = bookService.addBook(book);
        return result;
    }
    @PutMapping("/associateBookAndAuthor")
    public String associateBookAndAuthor(@RequestParam("bookId")Integer bookId,
                                         @RequestParam("authorId")Integer authorId){
        String result = ;
    }
}
