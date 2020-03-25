package ru.ifmo.base.school;

public class Director extends Man {

    public Director(String name, int age) {
        super(name, age);
    }
    public void beginLessons() {
        System.out.println("Начало занятий");
    }
    public void endLessons() {
        System.out.println("Конец занятий");
    }
}
