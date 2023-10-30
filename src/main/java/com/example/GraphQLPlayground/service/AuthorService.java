package com.example.GraphQLPlayground.service;

import com.example.GraphQLPlayground.model.Author;
import com.example.GraphQLPlayground.model.AuthorRepository;
import com.example.GraphQLPlayground.model.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
}
