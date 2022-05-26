package com.shareExp.backend.model;


import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.annotation.CreatedDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="comment")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"},
        allowGetters = true)
public class Comment  {
    public Comment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_clients")
    @Nullable
   private ShareExpClient name;

    @Column(nullable = true, updatable = true)
    private String content;

    @Column(nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    public Comment(ShareExpClient name, String content) {
        this.name = name;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setName(ShareExpClient name) {
        this.name = name;
    }

    public ShareExpClient getName() {
        return name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


}