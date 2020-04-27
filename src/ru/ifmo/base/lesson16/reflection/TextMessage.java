package ru.ifmo.base.lesson16.reflection;

import java.io.Serializable;

public class TextMessage extends Message implements Serializable {
    private String text;
    public String publicText;

    public TextMessage(String title) {
        super(title);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private void printText(String prefix, String postfix){
//        System.out.println(prefix + " " + text + " " + postfix);
        text = prefix + " " + text + " " + postfix;
        System.out.println(text);
    }
    @Override
    public String toString() {
        return "TextMessage{" +
                "text='" + text + '\'' +
                ", publicText='" + publicText + '\'' +
                '}';
    }
}
