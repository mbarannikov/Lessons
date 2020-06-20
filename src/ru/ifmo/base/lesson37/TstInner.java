package ru.ifmo.base.lesson37;

import java.util.Arrays;

public class TstInner {
    public static void main(String[] args) {
        // Внутренние классы (inner classes):
        // Нестатические вложенные классы (Non-static nested classes) -
        // Локальные классы (local class)
        // Анонимные классы
        User user = new User("qwe", User.Level.HIGH);
        // Объект внутреннего класса не может существовать без объекта внешнего класса (объект Account без объекта User)
        User.Account account = user.new Account(200);
        System.out.println(account.getInfo());

        User.Account someAccount = new User("asd", User.Level.MEDIUM).new Account(100);

        // Статические вложенные классы (static nested classes)
        Student student = new Student("Кирилл");
        // создание объекта вложенного класса
        Student.Exam math = new Student.Exam("математика", 4);
        Student.Exam rl = new Student.Exam("русский язык", 3);
        student.getExams().addAll(Arrays.asList(math, rl));
        student.passInfo();

        math.examInfo();
        rl.examInfo();

    }
}
