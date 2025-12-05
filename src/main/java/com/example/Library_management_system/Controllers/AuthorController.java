package com.example.Library_management_system.Controllers;

import com.example.Library_management_system.Entities.Author;
import com.example.Library_management_system.Entities.Book;
import com.example.Library_management_system.Services.AuthorService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author) {

        String result = authorService.addAuthor(author);
        return result;
    }

    @GetMapping("/getAuthorWithMaxBooks")
    public Author getAuthor(){

        Author ansAuthor = authorService.getAuthorWithMaxBooks();
        return ansAuthor;
    }

}
