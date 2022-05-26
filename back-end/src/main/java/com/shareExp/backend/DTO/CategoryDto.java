package com.shareExp.backend.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class CategoryDto implements Serializable {
    private final String name;
    private final MultipartFile image;

    public String getName() {
        return name;
    }

    public MultipartFile getImage() {
        return image;
    }
}
