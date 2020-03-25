package ru.ifmo.base.school;

public class Student extends Man implements Learn{
    private String subject;
    private  int studyLevel;

    public Student(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public int getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(int studyLevel) {
        this.studyLevel = studyLevel;
    }

    @Override
    public void learn() {
        System.out.println("Student "+this.getName()+" is learning");
        studyLevel++;
    }
}
