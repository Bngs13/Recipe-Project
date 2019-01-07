package com.group.artifact.service.Image;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void save(Long recipeId, MultipartFile file);
}
