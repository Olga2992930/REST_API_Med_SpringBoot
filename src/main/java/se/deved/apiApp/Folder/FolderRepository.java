package se.deved.apiApp.Folder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<FolderDto, Long> {
    FolderDto findByName(String name);
}

