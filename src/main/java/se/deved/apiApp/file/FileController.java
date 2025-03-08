package se.deved.apiApp.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/{folderId}")
    public ResponseEntity<FileEntity> uploadFile(
            @PathVariable Long folderId,
            @RequestParam String name,
            @RequestBody String base64Content) {
        return ResponseEntity.ok(fileService.uploadFile(name, base64Content, folderId));
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long fileId) {
        fileService.deleteFile(fileId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<String> downloadFile(@PathVariable Long fileId) {
        return ResponseEntity.ok(fileService.downloadFile(fileId));
    }

    @GetMapping("/folder/{folderId}")
    public ResponseEntity<List<FileEntity>> getFilesInFolder(@PathVariable Long folderId) {
        return ResponseEntity.ok(fileService.getFilesInFolder(folderId));
    }
}
