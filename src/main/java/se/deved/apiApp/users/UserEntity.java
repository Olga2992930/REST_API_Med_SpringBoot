package se.deved.apiApp.users;

import jakarta.persistence.*;
import lombok.Data;
import se.deved.apiApp.folders.FolderEntity;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String oidcId; // GitHub ID

    @Column(unique = true, nullable = false)
    private String username; // GitHub användarnamn

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<FolderEntity> folders;
}
