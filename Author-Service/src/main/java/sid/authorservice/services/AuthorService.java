package sid.authorservice.services;

import sid.authorservice.entities.Author;

import java.util.List;

public interface AuthorService {

    Author getAuthorById(String id) throws Exception;
    List<Author>  authorList();
    Author saveAuthor(Author author);

}
