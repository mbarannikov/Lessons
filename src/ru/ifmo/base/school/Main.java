package ru.ifmo.base.school;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Гриша",11,"Математика");
        Student s2 = new Student("Петя",12,"Химия");
        Student s3 = new Student("Аня",13,"Физика");
        Student s4 = new Student("Галя",14,"География");
        Teacher t1 = new Teacher("Тамара Николаевна",33,"Математика");
        Teacher t2 = new Teacher("Светлана Леонидовна",34,"География");
//        Student[] ss = {s1,s2,s3,s4};
//        Teacher[] tt = {t1,t2}
        Director dir = new Director("Василий Петрович",55);
        System.out.println(s1.getName()+" "+s1.getStudyLevel());
        System.out.println(s4.getName()+" "+s4.getStudyLevel());
        School sch = new School("Первая школа",dir);

        sch.addStudent(s1);
        sch.addStudent(s2);
        sch.addStudent(s4);
        sch.addTeacher(t1);
        sch.addTeacher(t2);
        sch.schoolDay();
        System.out.println(s1.getName()+" "+s1.getStudyLevel());
        System.out.println(s4.getName()+" "+s4.getStudyLevel());
    }
}
