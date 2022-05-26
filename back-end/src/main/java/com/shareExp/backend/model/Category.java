package com.shareExp.backend.model;


import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category {
    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, updatable = true)
    private String name;

    @Column(nullable = true, updatable = true)
    private String image;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category(String name) {
        this.name = name;

    }
}
