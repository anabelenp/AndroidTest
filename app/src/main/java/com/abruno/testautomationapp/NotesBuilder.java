package com.abruno.testautomationapp;

public class NotesBuilder {

    private String title, content, updatedDate, updatedTime;

    public NotesBuilder() {
    }

    public NotesBuilder(String title, String content, String updatedDate, String updatedTime) {
        this.title = title;
        this.content = content;
        this.updatedDate = "last modified: " + updatedDate;
        this.updatedTime = updatedTime;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
