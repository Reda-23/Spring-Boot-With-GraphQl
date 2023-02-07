package sid.authorservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Author {


    @Id
    private String id;

    private String name;

    private String email;

    private int age;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    List<Book> books;

    public Author(String id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
