package org.community.app.controller;

import org.community.app.service.FileService;
import org.community.core.domain.LocalFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by frodoking on 2016/12/27.
 */
@Controller
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @GetMapping("/file/upload")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files", fileService.getAll());
        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = null;//storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    @PostMapping("/file/post")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        fileService.save(file);
        return "redirect:/file/upload";
    }
}
