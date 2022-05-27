package com.shareExp.backend.DTO;

import com.shareExp.backend.model.Experience;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

@Data
public class ExpRequestDto implements Serializable {
    Long id;
    private final String title;
    private final int likes;
    private final String description;
    ShareExpClientDto shareExpClientDto;
    String image;
    Date creationDate;

    public ExpRequestDto(Experience exp){
        this.id = exp.getId();
        this.title = exp.getTitle();
        this.likes = exp.getLikes();
        this.description= exp.getDescription();
        this.image= exp.getImage();
        this.creationDate = exp.getCreationDate();

    }

}
