package sid.authorservice.services;

import sid.authorservice.entities.Book;

import java.util.List;

public interface BookService {


    Book findBookById(String id);
    List<Book> bookList();
    Book getBookByAuthorName(String authorName);

    Book saveBook(Book book);
}
