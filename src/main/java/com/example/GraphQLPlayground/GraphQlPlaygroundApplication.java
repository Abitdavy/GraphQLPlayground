package com.example.GraphQLPlayground;

import com.example.GraphQLPlayground.model.Author;
import com.example.GraphQLPlayground.model.AuthorRepository;
import com.example.GraphQLPlayground.model.Book;
import com.example.GraphQLPlayground.model.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GraphQlPlaygroundApplication {
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(GraphQlPlaygroundApplication.class, args);
	}

	@PostConstruct
	public void setupData(){
		System.out.println("setting up data");
		Author author1 = new Author();
		author1.setName("abet");

		Author author2 = new Author();
		author2.setName("josh");

		System.out.println(author1);
		System.out.println(author2);

		authorRepository.saveAll(List.of(author1, author2));

		// Create and save books associated with authors
		Book book1 = new Book();
		book1.setTitle("Book 1");
		book1.setPublisher("Publisher 1");
		book1.setAuthor(author1);
		Book book2 = new Book();
		book2.setTitle("Book 2");
		book2.setPublisher("Publisher 2");
		book2.setAuthor(author1);
		Book book3 = new Book();
		book3.setTitle("Book 3");
		book3.setPublisher("Publisher 3");
		book3.setAuthor(author2);

		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book3);

		bookRepository.saveAll(List.of(book1, book2, book3));
	}
}
