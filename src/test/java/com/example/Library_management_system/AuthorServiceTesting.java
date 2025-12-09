package com.example.Library_management_system;

import com.example.Library_management_system.Entities.Author;
import com.example.Library_management_system.Repositories.AuthorRepository;
import com.example.Library_management_system.Services.AuthorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

    @ExtendWith(MockitoExtension.class)
    public class AuthorServiceTesting {

        @Mock
        private AuthorRepository authorRepository;

        @InjectMocks
        private AuthorService authorService;

        @Test
        public void testMaxBooksAuthor() {

            Author a1 = new Author(1, 3);
            Author a2 = new Author(2, 5);
            Author a3 = new Author(3, 7);

            Mockito.when(authorRepository.findAll()).thenReturn(List.of(a1, a2, a3));

            Author actualAuthor = authorService.getAuthorWithMaxBooks();

            Assertions.assertEquals(a3, actualAuthor);
        }
    }


