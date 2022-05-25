package com.shareExp.backend.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
@Data
public class CommentDto implements Serializable {
   ShareExpClientDto shareExpClientDto;
    private final String content;

    public ShareExpClientDto getShareExpClientDto() {
        return shareExpClientDto;
    }

    public void setShareExpClientDto(ShareExpClientDto shareExpClientDto) {
        this.shareExpClientDto = shareExpClientDto;
    }

    public CommentDto(String content, ShareExpClientDto shareExpClientDto ) {
        this.content = content;
        this.shareExpClientDto=shareExpClientDto;
    }

    public String getContent() {
        return content;
    }


}
