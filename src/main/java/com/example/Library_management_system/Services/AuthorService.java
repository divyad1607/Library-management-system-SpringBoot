package com.example.Library_management_system.Services;

import com.example.Library_management_system.Entities.Author;
import com.example.Library_management_system.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String addAuthor(Author author){
        author.setNoOfBooks(0);
        authorRepository.save(author);
        return "Author has been save to the DB";
    }

    public Author getAuthorWithMaxBooks(){

        List<Author> authorList = authorRepository.findAll();
        Author ansAuthor = null;
        int maxBooks = 0;

        for(Author author:authorList){
            if (author.getNoOfBooks()>maxBooks){
                maxBooks = author.getNoOfBooks();
                ansAuthor = author;
            }
        }
        return ansAuthor;
    }
}

