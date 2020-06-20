package ru.ifmo.base.lesson21;

import java.util.function.UnaryOperator;

public class LambdaAndVars {
    private static int staticInt = 12;

    public static void main(String[] args) {
        int x = 10;
        Data localData = new Data("Текстовые данные");

        // UnaryOperator<T> : T apply(T t);
        UnaryOperator<Integer> unaryOperator = n -> { // не x -> {
            // не можем изменять значения локальных переменных
            // x = 10000;
            // localData = new Data("Текст!!!");
            // можно прочитать значения локальных переменных:
            System.out.println("localData: " + localData);
            System.out.println("x: " + x);
            // можно изменить свойства объекта:
            localData.setText("новый лямбда текст");

            // статические переменные доступны
            // и для изменения и для чтения
            staticInt = 20000;
            System.out.println("staticInt: " + staticInt);
            return n + 5;
        };
    }
}

class Data {
    private String text;

    public Data(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}