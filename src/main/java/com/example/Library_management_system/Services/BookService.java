package com.example.Library_management_system.Services;

import com.example.Library_management_system.Entities.Author;
import com.example.Library_management_system.Entities.Book;
import com.example.Library_management_system.Exceptions.InvalidPageCountException;
import com.example.Library_management_system.Repositories.AuthorRepository;
import com.example.Library_management_system.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(Book book) throws Exception {
        if (book.getNoOfPages()<=0){
            throw new InvalidPageCountException("Pages Count entered is incorrect");
        }
        bookRepository.save(book);
        return "Book has been saved to the DB with bookId "+book.getBookId();
    }

    public String associateBookAndAuthor(Integer bookId, Integer authorId){
        Book book = bookRepository.findById(bookId).get();
        Author author = authorRepository.findById(authorId).get();

        //associate book and author entity
        book.setAuthor(author);
        author.setNoOfBooks(author.getNoOfBooks()+1);

        bookRepository.save(book);
        authorRepository.save(author);

        return "Book and Author has been associated";

    }

    public List<Book> findBooksByAuthor(Integer authorId){

        List<Book> allBooks = bookRepository.findAll();

        List<Book> ansList = new ArrayList<>();
        for(Book book:allBooks){
            if(book.getAuthor().getAuthorId().equals(authorId)){
                ansList.add(book);
            }
        }
        return ansList;
    }

}
