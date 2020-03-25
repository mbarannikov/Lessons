package ru.ifmo.base.lesson9;

import java.util.Objects;

public class Author implements Cloneable{
    private String name;
    private String surName;

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(surName, author.surName);
    }

    @Override
    public Author clone() throws CloneNotSupportedException {
        return (Author) super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }

    public String getSurName() {
        return surName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
