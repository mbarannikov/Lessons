package ru.ifmo.base.lesson24;

import java.util.ArrayList;

import static java.lang.Thread.*;

public class WaitNotify {
    public static void main(String[] args) {
//        putThreads -> [storage] -> getThreads
        BookStorage bookStorage = new BookStorage();
        new Thread(new GetThread(bookStorage)).start();
        new Thread(new GetThread(bookStorage)).start();
        new Thread(new PutThread(bookStorage)).start();
        new Thread(new PutThread(bookStorage)).start();


    }
}

class Book {

}

class BookStorage{
    private ArrayList<Book> books = new ArrayList<>();
    public synchronized void putBook (Book book) throws InterruptedException {
        System.out.println("PUT_BOOK: start");

        while (books.size() > 5){
            notify(); // notifyAll() // from synchronized block or method
//            будет любой поток (или все), который был приостановлен wait
            System.out.println("PUT_BOOK: waiting. Book = "+ books.size());
            wait();   // освобождает монитор, объект доступен другим потокам
//            сам поток переходит в состояние ожидания до тех пор пока
//            не будет разбужен notify
        }
        books.add(book);
        System.out.println("PUT_BOOK: add 1 book. Books = " + books.size());
        System.out.println("PUT_BOOK: end");
    }

    public synchronized void getBook() throws InterruptedException {
        System.out.println("GET_BOOK: start");
        while (books.size() < 1){
            notify();
            System.out.println("GET_BOOK: waiting. Book = " + books.size());
            wait();
        }
        books.remove(0);
        System.out.println("GET_BOOK: take 1 book. Book = " + books.size());
        System.out.println("GET_BOOK: end");
    }

}

class PutThread implements Runnable{
    private BookStorage bookStorage;

    public PutThread(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(currentThread().getName() +
                    "PUT data for bookStorage");
            try {
                Thread.sleep(500);
                bookStorage.putBook(new Book());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class GetThread implements Runnable{
    private BookStorage bookStorage;

    public GetThread(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(currentThread().getName() +
                    "GET data from bookStorage");
            try {
                Thread.sleep(1000);
                bookStorage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
