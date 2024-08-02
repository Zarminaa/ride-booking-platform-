package com.example.javafxtest;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MessageClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private String content;
    private LocalDateTime timestamp;

    public MessageClass(String content, LocalDateTime timestamp) {

        this.content = content;
        this.timestamp = timestamp;
    }


    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}