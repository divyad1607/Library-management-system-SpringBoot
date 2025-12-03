package com.example.Library_management_system.Services;

import com.example.Library_management_system.Entities.Book;
import com.example.Library_management_system.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public String addBook(Book book){
        bookRepository.save(book);
        return "Book has been saved to the DB";
    }
    public String associateBookAndAuthor(Integer bookId, Integer authorId){
        
    }


}
