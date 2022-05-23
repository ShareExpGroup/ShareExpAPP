package com.shareExp.backend.model;

import com.sun.istack.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Inheritance
@Entity
@Table(name="experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client" ,insertable = false, updatable = false)
    @Nullable
    private ShareExpClient shareExpClient;

    @NotNull(message = "Title is required")
    @NotEmpty(message = "Title should not be empty")
    private String title;

    // I removed the notNull condition when i added the second constructor
    // @NotNull(message = "Creation date is required")
    private Date creationDate;
    private Integer like;
    //to resolve comment
    // List<Comment> comment


    public Experience(ShareExpClient shareExpClient, String title, Date creationDate, int like, String description) {
        this.shareExpClient = shareExpClient;
        this.title = title;
        this.creationDate = creationDate;
        this.like = like;
        this.description = description;
    }
    @NotNull(message = "Description is required")
    @Column(name="description",columnDefinition="LONGTEXT")
    private String description;
    public String image;

    public Experience() {
    }

    public Experience(ShareExpClient shareExpClient, String title, int like, String description) {
        this.title = title;
        this.like = like;
        this.description = description;
        this.shareExpClient=shareExpClient;
    }

    public Experience(Long id, ShareExpClient shareExpClient, String title, Date creationDate, Integer like, String description, String image) {
        this.id = id;
        this.shareExpClient = shareExpClient;
        this.title = title;
        this.creationDate = creationDate;
        this.like = like;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShareExpClient getShareExpClient() {
        return shareExpClient;
    }

    public void setShareExpClient(ShareExpClient shareExpClient) {
        this.shareExpClient = shareExpClient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
