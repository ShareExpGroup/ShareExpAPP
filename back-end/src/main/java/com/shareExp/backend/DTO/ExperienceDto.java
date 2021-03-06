package com.shareExp.backend.DTO;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class ExperienceDto implements Serializable {
    @NotNull(message = "Title is required")
    @NotEmpty(message = "Title should not be empty")
    private final String title;
    private final int like;
    @NotNull(message = "Description is required")
    private final String description;
    MultipartFile image;
private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ExperienceDto(String title, int like, String description, MultipartFile image, String category) {
        this.title = title;
        this.like = like;
        this.description = description;
        this.image = image;
        this.category=category;
    }

    public String getTitle() {
        return title;
    }

    public int getLike() {
        return like;
    }

    public String getDescription() {
        return description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

  /*  public ExperienceDto(Experience experience) {*/

    /*
    public ExperienceDto(Experience experience) {
        this.title = experience.getTitle();
        this.like = experience.getLikes();
        this.description = experience.getDescription();
    }*/

}
