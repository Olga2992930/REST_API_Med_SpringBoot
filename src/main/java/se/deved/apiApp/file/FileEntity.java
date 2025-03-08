package se.deved.apiApp.file;

import jakarta.persistence.*;
import se.deved.apiApp.folders.FolderEntity;
import java.time.LocalDateTime;

@Entity
@Table(name = "files")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Lob
    @Column(nullable = false)
    private byte[] content;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private FolderEntity folder;

    private LocalDateTime createdAt;

    public FileEntity() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public byte[] getContent() { return content; }
    public void setContent(byte[] content) { this.content = content; }
    public FolderEntity getFolder() { return folder; }
    public void setFolder(FolderEntity folder) { this.folder = folder; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
