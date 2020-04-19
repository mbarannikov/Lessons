package ru.ifmo.base.lesson12;

public class ChatException extends Exception{
    public ChatException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Следите за кодом!!";
    }
}
