package ru.ifmo.base.lesson19.messages;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SimpleMessage implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime dateTime;

    public SimpleMessage(String sender, String text) {
        this.sender = sender;
        this.text = text;
        this.dateTime = LocalDateTime.now();
    }

    public SimpleMessage() {
    }

    public String getText() {
        return text;
    }

    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
    public static SimpleMessage getInstance(String sender, String text){
        return new SimpleMessage(sender, text);
    }
}
