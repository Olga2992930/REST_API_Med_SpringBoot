package se.deved.apiApp.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.deved.apiApp.Folder.FolderRepository;
import java.util.Base64;
import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FolderRepository folderRepository;

    @Transactional
    public FileDto uploadFile(String name, String base64Content, Long folderId) {
        var folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new RuntimeException("Folder not found: " + folderId));

        var file = new FileDto();
        file.setName(name);
        file.setContent(Base64.getDecoder().decode(base64Content));
        file.setFolder(folder);
        return fileRepository.save(file);
    }

    public String downloadFile(Long fileId) {
        var file = fileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found: " + fileId));
        return Base64.getEncoder().encodeToString(file.getContent());
    }

    @Transactional
    public void deleteFile(Long fileId) {
        fileRepository.deleteById(fileId);
    }

    public List<FileDto> getFilesInFolder(Long folderId) {
        var folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new RuntimeException("Folder not found: " + folderId));
        return fileRepository.findByFolder(folder);
    }
}


