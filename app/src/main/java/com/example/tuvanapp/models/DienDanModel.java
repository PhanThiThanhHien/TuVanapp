package com.example.tuvanapp.models;

public class DienDanModel {
    String image;
    String content;

    public DienDanModel() {
    }

    public DienDanModel(String image, String content) {
        this.image = image;
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
