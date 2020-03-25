package ru.ifmo.base.lesson6;

public class Author {
// свойства класса
    private String name;
    String surname;
// методы
//    this это ссылка на текущий объект у которого вызываем метод, Author
    public void setName(String name) {
//        "java".equals(someVar);
        if((name.length() >= 2) &&(!"".equals(name))&& (name != null)){
            this.name = name;
        } else
        {this.name = "Empty";}
    }

    public void setSurname(String surname) {
        this.surname = surname;
        return;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
