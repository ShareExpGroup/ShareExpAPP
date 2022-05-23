package com.shareExp.backend.DTO;

import java.io.Serializable;
import java.util.Objects;

public class CommentDto implements Serializable {
   ShareExpClientDto shareExpClientDto;
    private final Long id;
    private final String content;

    public ShareExpClientDto getShareExpClientDto() {
        return shareExpClientDto;
    }

    public void setShareExpClientDto(ShareExpClientDto shareExpClientDto) {
        this.shareExpClientDto = shareExpClientDto;
    }

    public CommentDto(Long id, String content, ShareExpClientDto shareExpClientDto ) {
        this.id = id;
        this.content = content;
        this.shareExpClientDto=shareExpClientDto;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto entity = (CommentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.content, entity.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "content = " + content + ")";
    }
}
