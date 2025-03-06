package se.deved.apiApp.File;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.deved.apiApp.folders.FolderEntity;
import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileDto, Long> {
    List<FileDto> findByFolder(FolderEntity folder);
    void deleteByFolderId(Long folderId);
}
