package ru.ifmo.base.school;

public class School {
    // учителя учать только учеников по предметам
    // учиться - повышает уровень знаний - интерфейс
    // учить - передается ученик - учиться - отдельные интерфейсы
    private final String TITLE;
    private Student[] students = new Student[4];
    private Teacher[] teachers = new Teacher[2];
    private Director director;

    public School(String TITLE, Director director) {
        this.TITLE = TITLE;
        this.director = director;
    }

    public void addTeacher(Teacher t){
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null){teachers[i] = t;return;}
        }
    }
    public void addStudent (Student s){
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null){students[i] = s; return;}
        }
    }

    public void schoolDay() {
        if ("".equals(director.getName())) {
            System.out.println("школа не может функционировать без директора");
        } else {
            director.beginLessons();
            for (Teacher t:teachers) {
                if (t != null) {
                    for (Student s:students) {
                        if((s != null)&&(t.getSubject().equals(s.getSubject()))){
                            t.teach(s);
                        }
                    }
//                    for (int j = 0; j < students.length; j++) {
//                        if (teachers[i].getSubject().equals(students[j].getSubject())) {
//                            teachers[i].teach(students[j]);
//                        }
//                    }
                }
            }
            director.endLessons();

        }
    }
}

