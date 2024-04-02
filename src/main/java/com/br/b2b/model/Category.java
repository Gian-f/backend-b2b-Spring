package com.br.b2b.model;

public class Category {
    Long id;
    String name;
    String image;
    String creationAt;
    String updatedAt;

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

    public String getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(String creationAt) {
        this.creationAt = creationAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
