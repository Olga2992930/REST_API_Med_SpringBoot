package se.deved.apiApp.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.deved.apiApp.folders.FolderEntity;
import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    List<FileEntity> findByFolder(FolderEntity folder);
    void deleteByFolderId(Long folderId);
}
