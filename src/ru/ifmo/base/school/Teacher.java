package ru.ifmo.base.school;

public class Teacher extends Man implements Teach {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void setAge(int age) {
        if (age >25){
        this.age = age;
    }
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void teach(Learn stud) {
        System.out.println("Учитель " + this.getName() + " учит");
        stud.learn();
//        if (stud.getSubject() != null && this.getSubject() != null &&stud.getSubject() == this.getSubject()) {
//            System.out.println("Учитель " + this.getName() + " учит");
//            stud.learn();
//        }
    }
}
