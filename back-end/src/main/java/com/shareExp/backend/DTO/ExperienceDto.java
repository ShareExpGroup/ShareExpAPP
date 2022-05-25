package com.shareExp.backend.DTO;

import com.shareExp.backend.model.Experience;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class ExperienceDto implements Serializable {
    private final String title;
    private final int like;
    private final String description;
    MultipartFile image;

    public ExperienceDto(String title, int like, String description, MultipartFile image) {
        this.title = title;
        this.like = like;
        this.description = description;
        this.image = image;
    }

    public ExperienceDto(Experience experience) {
        this.title = experience.getTitle();
        this.like = experience.getLikes();
        this.description = experience.getDescription();
    }
}
