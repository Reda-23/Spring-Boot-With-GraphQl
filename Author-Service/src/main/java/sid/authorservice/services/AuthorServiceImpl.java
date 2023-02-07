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
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Author getAuthorById(String id) throws Exception {
        Author author = authorRepository.findAuthorById(id);
        if (author.getId().isEmpty()) throw new RuntimeException(String.format("%s is not found",id));
        return author;
    }

    @Override
    public List<Author> authorList() {
        return authorRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
}
