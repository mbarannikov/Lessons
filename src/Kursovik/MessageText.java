package Kursovik;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MessageText implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime dateTime;

    public MessageText(String sender, String text) {
        this.sender = sender;
        this.text = text;
        this.dateTime = LocalDateTime.now();
    }

    public MessageText() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
    public static MessageText getInstance(String sender, String text){
        return new MessageText(sender, text);
    }
}
