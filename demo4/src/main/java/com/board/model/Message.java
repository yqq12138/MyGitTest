package com.board.model;

import java.util.Date;

public class Message {
    private int id;
    private String username;
    private String title;
    private String content;
    private Date timestamp;

    public Message(int id, String username, String title, String content, Date timestamp) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
