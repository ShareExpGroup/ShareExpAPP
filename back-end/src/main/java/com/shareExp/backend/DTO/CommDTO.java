package com.shareExp.backend.DTO;

import com.shareExp.backend.model.Comment;
import lombok.Data;

import java.io.Serializable;



@Data
public class CommDTO implements Serializable {
    ShareExpClientDto shareExpClientDto;
    Long experience;
    private final String content;

    public  Long getExperience() {
        return experience;
    }

    public void setExperience( Long experience) {
        this.experience = experience;
    }

    public ShareExpClientDto getShareExpClientDto() {
        return shareExpClientDto;
    }

    public void setShareExpClientDto(ShareExpClientDto shareExpClientDto) {
        this.shareExpClientDto = shareExpClientDto;
    }

    public CommDTO(Comment com){
        this.content = com.getContent();
        this.experience = com.getName().getId();
        this.shareExpClientDto = new ShareExpClientDto(com.getName().getId(),com.getName().getFirstName(),com.getName().getLastName())

        ;

    }

    public String getContent() {
        return content;
    }


}
