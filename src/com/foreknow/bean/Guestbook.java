package com.foreknow.bean;

public class Guestbook {
    private  Integer id;
    private  String name;
    private  String phone;
    private  String email;
    private  String title;
    private  String content;
    private  String time;


    public Integer getId() {
        return this.id;
    }

    public int setId(Integer id) { this.id = id;
    return id;}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
