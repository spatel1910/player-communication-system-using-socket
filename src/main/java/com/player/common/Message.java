package com.player.common;

import java.io.Serializable;

public class Message implements Serializable {
    private final String sender;
    private final String content;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Message from " + sender + ": " + content;
    }
}