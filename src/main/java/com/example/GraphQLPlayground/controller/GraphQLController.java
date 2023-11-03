package com.example.GraphQLPlayground.controller;

import com.example.GraphQLPlayground.model.Author;
import com.example.GraphQLPlayground.model.Book;
import com.example.GraphQLPlayground.model.BookInput;
import com.example.GraphQLPlayground.model.Customer;
import com.example.GraphQLPlayground.service.AuthorService;
import com.example.GraphQLPlayground.service.BookService;
import com.example.GraphQLPlayground.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class GraphQLController {
    final BookService bookService;
    final AuthorService authorService;

    @Autowired
    private CustomerService customerService;

    public GraphQLController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @QueryMapping
    List<Book> getAllBooks() {
        System.out.println("start books servce");
        List<Book> books = bookService.getAllBooks();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("book service done");
        return books;
    }

    @QueryMapping
    List<Author> getAllAuthor(){
        System.out.println("start author service");
        List<Author> authors = authorService.getAuthors();
        System.out.println("author done");
        return authorService.getAuthors();
    }

    @QueryMapping
    Optional<Book> getBookById(@Argument Long id){
        return bookService.getBookById(id);
    }

    @QueryMapping
    List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
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
