package com.shareExp.backend.DTO;

import com.shareExp.backend.model.Experience;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
@Data
public class CommentDto implements Serializable {
   ShareExpClientDto shareExpClientDto;
   Experience experience;
    private final String content;

    public ShareExpClientDto getShareExpClientDto() {
        return shareExpClientDto;
    }

    public void setShareExpClientDto(ShareExpClientDto shareExpClientDto) {
        this.shareExpClientDto = shareExpClientDto;
    }

    public CommentDto(String content, Experience experience, ShareExpClientDto shareExpClientDto) {
        this.content = content;
        this.experience = experience;
        this.shareExpClientDto= shareExpClientDto;
    }

    public String getContent() {
        return content;
    }


}
