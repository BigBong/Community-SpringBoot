package org.community.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by frodoking on 2016/12/27.
 */
@Service
public class FileService {
    private static final String DEFAULT_DIR = "/";
    public List<String> getAll() {
        return null;
    }

    public void save(MultipartFile file) {
    }
}
