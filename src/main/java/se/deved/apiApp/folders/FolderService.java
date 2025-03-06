package se.deved.apiApp.folders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FolderService {
    @Autowired
    private FolderRepository folderRepository;

    @Transactional
    public FolderEntity createFolder(String name) {
        FolderEntity folder = new FolderEntity();
        folder.setName(name);
        return folderRepository.save(folder);
    }

    public List<FolderEntity> getAllFolders() {
        return folderRepository.findAll();
    }

    public FolderEntity getFolderById(Long id) {
        return folderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Folder not found: " + id));
    }

    @Transactional
    public void deleteFolder(Long id) {
        folderRepository.deleteById(id);
    }
}
