package org.community.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.community.property.CustomProperties;
import org.community.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by frodoking on 2016/12/27.
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class FileUploadController {

    @Autowired
    private FileService fileService;
    @Autowired
    private CustomProperties customProperties;

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        log.info("Request params [name: " + filename + "]");
        Resource resource = null;
        String rootPath = customProperties.getFileSystemDir();
        File dir = new File(rootPath);
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File f : files) {
                if (f.getName().equals(filename)) {
                    resource = new FileSystemResource(f);
                    break;
                }
            }
        }

        if (resource == null) {
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/file/uploadFile")
    public ResponseJsonWrapper<String> handleFileUpload(@RequestParam("name") String name,
                                                        @RequestParam("file") MultipartFile file) {

        log.info("Request params [name: " + name + ", originFileName: " + file.getName() + "]");

        ResponseJsonWrapper<String> responseJsonWrapper = new ResponseJsonWrapper<>();
        responseJsonWrapper.setStatus(300);
        responseJsonWrapper.setMessage("");
        responseJsonWrapper.setData("");
        String message;
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = customProperties.getFileSystemDir();
                File dir = new File(rootPath);
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                responseJsonWrapper.setStatus(200);
                responseJsonWrapper.setMessage("You successfully uploaded file=" + name);
                return responseJsonWrapper;
            } catch (Exception e) {
                message = "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            message = "You failed to upload " + name + " because the file was empty.";
        }
        responseJsonWrapper.setMessage(message);
        return responseJsonWrapper;
    }

    @PostMapping("/file/uploadMultipleFile")
    public ResponseJsonWrapper<String> uploadMultipleFileHandler(@RequestParam("name") String[] names,
                                                                 @RequestParam("file") MultipartFile[] files) {
        ResponseJsonWrapper<String> responseJsonWrapper = new ResponseJsonWrapper<>();
        responseJsonWrapper.setStatus(300);
        responseJsonWrapper.setMessage("");
        responseJsonWrapper.setData("");
        if (files.length != names.length) {
            responseJsonWrapper.setMessage("Mandatory information missing");
            return responseJsonWrapper;
        }

        String message = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = names[i];
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = customProperties.getFileSystemDir();
                File dir = new File(rootPath);
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                log.info("Server File Location=" + serverFile.getAbsolutePath());

                responseJsonWrapper.setStatus(200);
                message = message + "You successfully uploaded file=" + name;
            } catch (Exception e) {
                message = "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        responseJsonWrapper.setMessage(message);
        return responseJsonWrapper;
    }
}
