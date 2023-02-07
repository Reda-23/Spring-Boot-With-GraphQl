package sid.authorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sid.authorservice.entities.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {

    Book findBookByAuthorName(String authorName);
    Book findBookById(String id);
}
