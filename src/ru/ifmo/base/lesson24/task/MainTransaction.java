package ru.ifmo.base.lesson24.task;

public class MainTransaction {

    public static void main(String[] args) {
        Account src = new Account(1, 1000);
        Account dst = new Account(2, 1000);
        Bank bank = new Bank();
        for (int i = 0; i < 10; i++) {
                bank.transferMoney(src, dst, 1000);
                bank.transferMoney(dst, src, 1000);
        }

//        Thread transferMoney = new Thread(bank.transferMoney(account1,account2,1000));
//        transaction.start();

//        try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("account1 balance = " + src.getBalance());
            System.out.println("account2 balance = " + dst.getBalance());
        }

    }
