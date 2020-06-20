package ru.ifmo.base.lesson24.task;

public class Account {

    private int id; // unique (1,2,3,4,5...)
    private int balance; // доступные средства на аккаунте


    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}