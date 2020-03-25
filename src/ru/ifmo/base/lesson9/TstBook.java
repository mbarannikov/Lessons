package ru.ifmo.base.lesson9;

public class TstBook {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Object - родительский класс
        Object obj = new Object();
        // toString() - возвращает строковое представление объектов
        Author author = new Author();
        author.setName("Иван");
        author.setSurName("Григорьев");
        Author author2 = new Author();
        author2.setName("Иван2");
        author2.setSurName("Григорьев2");
        ChildBook book1 = new ChildBook(new String[] {"dog","cat"});
        book1.setTitle("Детская книга");
        book1.setPageCount(230);
        book1.setAuthor(author);
        String stringBook = book1.toString();
        System.out.println(stringBook);

        ChildBook book2 = new ChildBook(new String[] {"dog","cat"});
        book2.setTitle("Детская книга123");
        book2.setPageCount(2301);
        book2.setAuthor(author2);
        //2. equals(Object other) - сравнение объекта
        // 3. HashCode() - возвращает хешкод объекта
       ChildBook book3 = book1;
        boolean equalsBooks = book1.equals(book2);
        System.out.println(equalsBooks);
        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());
        System.out.println(book3.hashCode());

        // 4.clone() - метод создания копии объекта
        ChildBook cloneBook = book1.clone(); // ссылки на один объект
        ChildBook cloneBook2 = book2.clone();
        //1. использовать базовую реализацию, тогда класс должен реализовать интерфейс Cloneable
        // расширить модификатор доступа до public и выполнить приведение типов, изменить тип возвращаемого значения
        //2. без использования базовой реализации, класс не обязан реализовывать интерфейс Cloneable
        // необходимо написать свою реализацию по созданию копии объекта
        System.out.println(cloneBook);
        System.out.println(cloneBook2);
    }
}
