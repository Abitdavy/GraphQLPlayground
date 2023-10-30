package com.example.GraphQLPlayground.service;

import com.example.GraphQLPlayground.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    final AuthorRepository authorRepository;
    final BookRepository bookRepository;

    public BookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        List<Book> booksList = new ArrayList<>();
        try {
            booksList = bookRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
        return booksList;
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public Book addBookWithAuthor(BookInput bookInput){
        Author author = authorRepository.findById(bookInput.getAuthorId()).orElseThrow(() -> new IllegalArgumentException("Author not found"));
        Book book = Book.builder()
                .title(bookInput.getTitle())
                .publisher(bookInput.getPublisher())
                .author(author)
                .build();
        return bookRepository.save(book);
    }

    public Book deleteBookById(Long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book Not Found"));
        bookRepository.deleteById(id);
        return book;
    }

    public Book updateBookById(BookInput bookInput){
        Book book = bookRepository.findById(bookInput.getBookId()).orElseThrow(() -> new IllegalArgumentException("Book Not Found"));
        book.setTitle(bookInput.getTitle());
        book.setPublisher(bookInput.getPublisher());
        return bookRepository.save(book);
    }
}
