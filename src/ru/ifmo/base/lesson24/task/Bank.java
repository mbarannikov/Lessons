package ru.ifmo.base.lesson24.task;

public class Bank {

    public void transferMoney(Account src, Account dst, int money){
        Thread transaction = new Thread(new Transaction(src, dst, money));
        transaction.start();
        try {
            transaction.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}