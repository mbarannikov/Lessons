package ru.ifmo.base.lesson14;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        Student student1 = new Student("Петр", "Алексеев", 18);
        Student student2 = new Student("Екатерина", "Еремина", 20);
        Student student3 = new Student("Денис", "Попов", 22);
        Student student4 = new Student("Петр", "Попов", 22);
        LinkedList<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.add(student1);
        studentLinkedList.add(student2);
        studentLinkedList.add(student1);

        studentLinkedList.add(1, student3);
        studentLinkedList.addFirst(null);
        studentLinkedList.forEach(System.out::println);
        System.out.println("---LinkedList---");
        System.out.println(studentLinkedList);
        System.out.println(studentLinkedList.getFirst());
        System.out.println(studentLinkedList.getLast());
        System.out.println(studentLinkedList.get(2));

        studentLinkedList.removeFirst();
        studentLinkedList.removeLast();
        studentLinkedList.remove(1);
        studentLinkedList.remove(student1);
        studentLinkedList.remove();
        studentLinkedList.forEach(System.out::println);
        System.out.println("---ArrayList---");
        ArrayList<Student> studentArrayList = new ArrayList<>(20);
        System.out.println(studentArrayList.size());
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(1,null);
        System.out.println(studentArrayList);
        System.out.println(studentArrayList.size());
        studentArrayList.trimToSize();
        System.out.println(studentArrayList.size());
        System.out.println("sublist " + studentArrayList.subList(0,2));
studentArrayList.remove(student1);
studentArrayList.remove(1);
        System.out.println(studentArrayList);

        Student[] studentsArray = {student1,student2,student3};
        List<Student> arrAsList = Arrays.asList(studentsArray);
        studentArrayList.addAll(arrAsList);
        System.out.println("---Interface Set---");
        System.out.println("---HashSet---");
        HashSet<Student> studentHashSet = new HashSet<>(arrAsList);
        studentHashSet.add(null);
        System.out.println(studentHashSet);
        System.out.println(studentHashSet.size());
        System.out.println(studentHashSet.iterator());
        System.out.println("---LinkedHashSet---");
        LinkedHashSet<Student> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(student1);
        linkedHashSet.add(student2);
        linkedHashSet.add(null);
        System.out.println("LinkedHashSet " + linkedHashSet);
        System.out.println("---TreeSet---");
        TreeSet<Student> treeSet1 = new TreeSet<>();
        treeSet1.add(student1);
        treeSet1.add(student2);
        treeSet1.add(student3);
        System.out.println("treeSet1 " + treeSet1);
        Comparator<Student>studentComparator = new StudentNameComparator().thenComparing(new StudentAgeComparator());
        TreeSet<Student> treeSet2 = new TreeSet<>(studentComparator);
        treeSet2.add(student1);
        treeSet2.add(student2);
        treeSet2.add(student3);
        treeSet2.add(student4);
        System.out.println("treeSet2 " + treeSet2);
LinkedList<Student> students = new LinkedList<>();
students.add(student1);
students.add(student2);
students.add(student3);
students.add(student4);
        for (Student s:students
             ) {
            System.out.println(s);
            System.out.println(s.getName());
//            if(s.getName().equals("Петр"))students.remove(s);
        }
        Iterator<Student> studentIterator = students.listIterator();
        while (studentIterator.hasNext()){
            if(studentIterator.hasNext()){
                if(studentIterator.next().getName().equals("Петр")){
                    studentIterator.remove();
                }
            }
        }
        System.out.println("students " + students);
    }
}