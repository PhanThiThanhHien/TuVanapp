package com.example.tuvanapp.models;

public class ThanhTuuModel {
    String image;
    String title;
    String content;

    public ThanhTuuModel() {
    }

    public ThanhTuuModel(String image, String title, String content) {
        this.image = image;
        this.title = title;
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
