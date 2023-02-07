package sid.authorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sid.authorservice.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Author findAuthorById(String id);
}
