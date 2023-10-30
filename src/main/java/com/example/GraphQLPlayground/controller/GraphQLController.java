package com.example.GraphQLPlayground.controller;

import com.example.GraphQLPlayground.model.Author;
import com.example.GraphQLPlayground.model.Book;
import com.example.GraphQLPlayground.model.BookInput;
import com.example.GraphQLPlayground.service.AuthorService;
import com.example.GraphQLPlayground.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class GraphQLController {
    final BookService bookService;
    final AuthorService authorService;

    public GraphQLController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @QueryMapping
    List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    List<Author> getAllAuthor(){
        return authorService.getAuthors();
    }

    @QueryMapping
    Optional<Book> getBookById(@Argument Long id){
        return bookService.getBookById(id);
    }

    @MutationMapping
    public Book addBook(@Argument BookInput bookInput){
        return bookService.addBookWithAuthor(bookInput);
    }

    @MutationMapping
    public Book deleteBook(@Argument Long id){
        return bookService.deleteBookById(id);
    }

    @MutationMapping
    public Book updateBook(@Argument BookInput bookInput){
        return bookService.updateBookById(bookInput);
    }

}
