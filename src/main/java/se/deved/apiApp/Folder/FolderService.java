package se.deved.apiApp.Folder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FolderService {
    @Autowired
    private FolderRepository folderRepository;

    @Transactional
    public FolderDto createFolder(String name) {
        FolderDto folder = new FolderDto();
        folder.setName(name);
        return folderRepository.save(folder);
    }

    public List<FolderDto> getAllFolders() {
        return folderRepository.findAll();
    }

    public FolderDto getFolderById(Long id) {
        return folderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Folder not found: " + id));
    }

    @Transactional
    public void deleteFolder(Long id) {
        folderRepository.deleteById(id);
    }
}
