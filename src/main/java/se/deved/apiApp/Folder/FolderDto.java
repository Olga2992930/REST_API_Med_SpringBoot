package se.deved.apiApp.Folder;

import jakarta.persistence.*;
import se.deved.apiApp.File.FileDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
public class FolderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileDto> files = new ArrayList<>();

    private LocalDateTime createdAt;

    public FolderDto() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<FileDto> getFiles() { return files; }
    public void addFile(FileDto file) {
        files.add(file);
        file.setFolder(this);
    }
    public void removeFile(FileDto file) {
        files.remove(file);
        file.setFolder(null);
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

