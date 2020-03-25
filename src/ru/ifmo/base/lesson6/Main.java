package ru.ifmo.base.lesson6;

public class Main {
    public static void main(String[] args) {
//        библиотека: можно добавлять книги по 1й или нескольо сразу, можно взять домой или только для чтения в библиотеке
//        книги:название, количество страниц, автор (имя фамилия), можно ли брать домой, доступна для выдачи
Author author1 = new Author();
//author1.name = "Брюс";
        author1.setName("");
//author1.surname = "";
//        System.out.println(author1.name);
        System.out.println(author1.getName());
        Author author2 = new Author();
//        author2.name = "Роберт";
        author2.setName("Роберт");
        String name = author2.getName();
        System.out.println(name);
        author1.setSurname("Эккель");
        author2.setSurname("Мартин");
        System.out.println(author1.getName()+" "+author1.getSurname());
        System.out.println(author2.toString());
        Book book1 = new Book("Философия Java");
        book1.setAuthor(author1);
        book1.setPageCount(1350);
        book1.setAuthor(author1);
        book1.setForHome(true);
        System.out.println(book1);
        Book book2 =  new Book("Чистый код", 500);
        book2.setAuthor(author2);
        System.out.println(book2);

        String book1AuthorName = book1.getAuthor().getName();
        System.out.println(book1AuthorName);

//      по умолчанию  ссылочные типы - null , целые числа - 0, boolean - false, число с плавающей точкой - 0.0
//      если описан хотя бы один конструктор, то конструктор без параметров уже не доступен

        Book [] books = {book1, book2};

        for (Book book: books) {
            System.out.println(book.getAuthor().getSurname());
        }

        Book[] books1 = new Book[5];
        Library lib = new Library();
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book1, book2);
        for (Book book: books) {
            System.out.println(book.getAuthor().getSurname());
        }
    }
}
