package se.deved.apiApp.users;

import jakarta.persistence.*;
import lombok.Data;
import se.deved.apiApp.folders.FolderEntity;
import java.util.List;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String oidcId;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<FolderEntity> folders;

}
