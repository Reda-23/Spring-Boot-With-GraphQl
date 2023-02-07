package sid.authorservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sid.authorservice.entities.Author;
import sid.authorservice.entities.Book;
import sid.authorservice.enums.Type;
import sid.authorservice.repository.AuthorRepository;
import sid.authorservice.repository.BookRepository;
import sid.authorservice.services.AuthorService;
import sid.authorservice.services.BookService;

import java.util.*;
import java.util.stream.Stream;

@SpringBootApplication
public class AuthorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(AuthorService authorService,
                            BookService bookService){
        return args -> {
           Author author1 = new Author("A1","John","john@gmail.com",34);
           Author author2 = new Author("A2","Sam","sam@gmail.com",25);
           Author author3 = new Author("A3","Elo","elo@gmail.com",58);
           authorService.saveAuthor(author1);
           authorService.saveAuthor(author2);
           authorService.saveAuthor(author3);


           Book book1 = new Book("B1","1984",Type.CLASSICES,author1);
           Book book2 = new Book("B2","Fury",Type.HORROR,author2);
           Book book3 = new Book("B3","Animal Farm",Type.YOUNG_ADULT,author3);
           Book book4 = new Book("B4","Beyond Good And Evil",Type.YOUNG_ADULT,author1);
           Book book5 = new Book("B5","24H",Type.CLASSICES,author3);
           bookService.saveBook(book1);
           bookService.saveBook(book2);
           bookService.saveBook(book3);
           bookService.saveBook(book4);
           bookService.saveBook(book5);




        };
    }

}
