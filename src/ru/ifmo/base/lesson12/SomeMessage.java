package ru.ifmo.base.lesson12;

public class SomeMessage {
    private String title;
    private String text;

    public SomeMessage(String title, String text) throws ChatException {
        setTitle(title);
        setText(text);
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setTitle(String title) throws ChatException {
        if(title.length() < 3){
            throw new ChatException("Длина title не может быть меньше 3");
        }
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }
}
