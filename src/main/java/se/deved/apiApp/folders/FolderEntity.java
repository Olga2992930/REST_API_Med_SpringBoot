package se.deved.apiApp.folders;

import jakarta.persistence.*;
import se.deved.apiApp.file.FileEntity;
import se.deved.apiApp.users.UserEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
public class FolderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileEntity> files = new ArrayList<>();

    private LocalDateTime createdAt;

    public FolderEntity() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<FileEntity> getFiles() { return files; }
    public void addFile(FileEntity file) {
        files.add(file);
        file.setFolder(this);
    }
    public void removeFile(FileEntity file) {
        files.remove(file);
        file.setFolder(null);
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

