package com.example.crammasterapp.announcements;

public class Announcements {
    private String title;
    private String body;

    public Announcements(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}