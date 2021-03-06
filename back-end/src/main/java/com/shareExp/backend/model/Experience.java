package com.shareExp.backend.model;

import com.sun.istack.Nullable;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Date;
@Entity

@JsonIgnoreProperties(value = {"creationDate"},
        allowGetters = true)
@Table
public class Experience {
    public Experience() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_clients")
    @Nullable
    private ShareExpClient shareExpClient;


    @Column(nullable = true, updatable = true)
    private String title;


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


    @Column(nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date creationDate;

    @Column(nullable = true, updatable = true)
    private Integer likes;
    @Column(nullable = true, updatable = true)
    private String description;
    @Column(nullable = true, updatable = true)
    private String image;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_category")
    @Nullable
    private Category category;



    public Experience(ShareExpClient shareExpClient, String title, int like, String description) {
        this.title = title;
        this.likes = like;
        this.description = description;
        this.shareExpClient=shareExpClient;
    }

    public Experience(Long id, ShareExpClient shareExpClient, String title, Date creationDate, Integer like, String description, String image) {
        this.id = id;
        this.shareExpClient = shareExpClient;
        this.title = title;
        this.creationDate = creationDate;
        this.likes = like;
        this.description = description;
        this.image = image;
    }

    public Experience(Experience experience){
        this.id = experience.getId();
        this.shareExpClient = experience.getShareExpClient();
        this.title = title;
        this.creationDate = experience.getCreationDate();
        this.likes = experience.getLikes();
        this.description = experience.getDescription();
        this.image = experience.getImage();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer like) {
        this.likes = like;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}