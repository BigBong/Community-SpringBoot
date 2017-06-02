package org.community.controller.web;

import org.community.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by frodo on 2016/12/29.
 */
@Controller
@RequestMapping("/web")
public class FileUploadWebController {

    @Autowired
    private FileService fileService;

    @GetMapping("/file/upload")
    public String listUploadedFiles(Model model) {
        model.addAttribute("files", fileService.getAll());
        return "file";
    }
}

