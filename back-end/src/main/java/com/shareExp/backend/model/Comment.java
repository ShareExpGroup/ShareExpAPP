package com.shareExp.backend.model;


import com.shareExp.backend.DTO.ExperienceDto;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import org.hibernate.annotations.CreationTimestamp;
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

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_experience")
    @Nullable
    private Experience experience;

    @Column(nullable = true, updatable = true)
    private String content;

    @Column(nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    public Comment(ShareExpClient name, String content, Experience experience) {
        this.name = name;
        this.content = content;
        this.experience = experience;
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