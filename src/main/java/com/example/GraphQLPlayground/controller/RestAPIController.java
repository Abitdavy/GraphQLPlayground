package com.example.GraphQLPlayground.controller;

import com.example.GraphQLPlayground.model.Author;
import com.example.GraphQLPlayground.model.Book;
import com.example.GraphQLPlayground.model.BookRepository;
import com.example.GraphQLPlayground.service.AuthorService;
import com.example.GraphQLPlayground.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class RestAPIController {
    private final BookService bookService;
    private final AuthorService authorService;

    private final BookRepository bookRepository;

    @Autowired
    public RestAPIController(BookService bookService, AuthorService authorService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        List<Book> books = bookService.getAllBooks();
        return books;
    }

    @GetMapping("/authors")
    public List<Author> getAuthor(){
        List<Author> authors = authorService.getAuthors();
        return authors;
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBooksByID(@PathVariable Long id){
        return bookService.getBookById(id);
    }
}
