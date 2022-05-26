package com.shareExp.backend.DTO;

import com.shareExp.backend.model.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
@Data
public class CatDTO implements Serializable {
    Long id;
   String name;
    String image;


    public CatDTO(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public CatDTO(Category category) {
        this(category.getId(),
                category.getName(),
                category.getImage()
        );
    }
}