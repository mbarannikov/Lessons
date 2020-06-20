package ru.ifmo.base.lesson21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaAndCollections {
    public static void main(String[] args) {

        Student student1 = new Student("Tom", 25, "Canada");
        Student student2 = new Student("Tim", 33, "Russia");
        Student student3 = new Student("Alex", 19, "China");
        Student student4 = new Student("Robert", 36, "Russia");
        Student student5 = new Student("Paul", 30, "China");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        University university = new University(students);
        // boolean test(Student student)
        Predicate<Student> russiaFilter =
                student -> "russia".equalsIgnoreCase(student.getCountry());
        System.out.println("---russiaFilter---");
        System.out.println(university.getFilteredStudent(russiaFilter));
        // старше 30 лет
        Predicate<Student> ageFilter = student -> student.getAge() > 30;
        System.out.println("---ageFilter---");
        System.out.println(university.getFilteredStudent(ageFilter));

        System.out.println("---ageFilter + russiaFilter---");
        System.out.println(
                university.getFilteredStudent(ageFilter.and(russiaFilter)));

        System.out.println("---Comparator.comparing---");
        // реализация метода compare
        Comparator<Student> byName = (std1, std2) -> std1.getName()
                .compareTo(std2.getName());

        // реализация метода apply() интерфейса Function
        // принимает на вход объект типа Student, возвращает объект
        Function<Student, Object> nameFunc = student -> student.getName();
        // аналогично: название аргумента - student не указывается и берется из контекста (объект типа Student)
        // Student::getName - реализация метода
        nameFunc = Student::getName; // через :: передается ссылка на метод или на конструктор
        // поэтому реализация метода getAge подходит в качестве реализации метода apply() интерфейса Function
        byName = Comparator.comparing(Student::getName);

        Comparator<Student> byAge = Comparator.comparing(Student::getAge);
        students.sort(byAge);
        Collections.reverse(students);

        students.sort(byAge.thenComparing(byName));

        System.out.println("---collection foreach---");
        //interface Consumer<T> : void accept(T t);
//        Consumer<Student> std = student -> student.setAge(student.getAge() + 10);
        students.forEach(student ->
                student.setAge(student.getAge() + 10));

//        for (Student student: students){
//            std.accept(student);
//        }

        students.forEach(System.out::println);

        System.out.println("---removeIf---");
        students.removeIf(student ->
                "china".equalsIgnoreCase(student.getCountry()));
        students.forEach(System.out::println);



    }
}

class University {
    private List<Student> studentList;

    public University(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getFilteredStudent(Predicate<Student> filter) {
        List<Student> students = new ArrayList<>();

        for (Student student : studentList) {
            if (filter.test(student)) students.add(student);
        }

        return students;
    }

}


class Student {
    private String name;
    private int age;
    private String country;

    public Student(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}
