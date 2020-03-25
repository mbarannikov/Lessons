package ru.ifmo.base.school;

abstract public class Man {
    protected String name;
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 5) {
            this.age = age;
        }
    }
    public int getAge() {
        return age;
    }

    public Man(String name, int age) {
        if(name != null){this.name = name;}
        setAge(age);
    }
}
