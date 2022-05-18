package com.example.tuvanapp.models;

public class ViewHDModel {
    String image;
    String title;
    String address;
    String time;
    String type;
    String content;

    public ViewHDModel() {
    }

    public ViewHDModel(String image, String title, String address, String time, String type, String content) {
        this.image = image;
        this.title = title;
        this.address = address;
        this.time = time;
        this.type = type;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
