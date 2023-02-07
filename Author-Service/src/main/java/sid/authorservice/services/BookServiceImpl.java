package sid.authorservice.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sid.authorservice.entities.Author;
import sid.authorservice.entities.Book;
import sid.authorservice.repository.AuthorRepository;
import sid.authorservice.repository.BookRepository;

import java.util.List;


@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book findBookById(String id) {
        Book book = bookRepository.findBookById(id);
        if (book.getId().isEmpty()) throw new RuntimeException(String.format("%s is not found",id));
        return book;
    }

    @Override
    public List<Book> bookList() {
        List<Book> bookList = bookRepository.findAll();
        if (bookList.isEmpty()) throw new RuntimeException("unavailable data");
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByAuthorName(String authorName) {
        Book book1 = bookRepository.findBookByAuthorName(authorName);
        if (book1.getId().isEmpty()) throw new RuntimeException(String.format("%s is not found",book1.getId()));
        return book1;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
