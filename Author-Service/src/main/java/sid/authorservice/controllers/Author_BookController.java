package sid.authorservice.controllers;



import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import sid.authorservice.entities.Author;
import sid.authorservice.entities.Book;
import sid.authorservice.services.AuthorServiceImpl;
import sid.authorservice.services.BookServiceImpl;

import java.util.List;

@Controller

public class Author_BookController {

    private  AuthorServiceImpl authorService;
    private  BookServiceImpl bookService;


    public Author_BookController(AuthorServiceImpl authorService, BookServiceImpl bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @QueryMapping
    public Book getBookById(@Argument String id){
        return bookService.findBookById(id);
    }

    @QueryMapping
    public List<Book> bookList(){
        return bookService.bookList();
    }

    //@QueryMapping
    public Book getAuthorByBookName(String id){
        return bookService.getBookByAuthorName(id);
    }


    //@QueryMapping
    public Author getAuthorById(String authorId) throws Exception {
        return authorService.getAuthorById(authorId);
    }

    @MutationMapping
    public Book saveBook(@Argument Book book){
        return bookService.saveBook(book);
    }

    @QueryMapping
    public List<Author> authorList(){
        return authorService.authorList();
    }

}
