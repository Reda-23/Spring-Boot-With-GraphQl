package sid.authorservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sid.authorservice.enums.Type;

import javax.persistence.*;

@Entity
@AllArgsConstructor @Data @NoArgsConstructor
public class Book {

    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type bookType;
    @ManyToOne
    private Author author;
}
