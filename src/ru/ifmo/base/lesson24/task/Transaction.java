package ru.ifmo.base.lesson24.task;

public class Transaction implements Runnable {

    private Account src; // с какого аккаунта осуществлять перевод
    private Account dst; // на какой аккаунт осуществлять перевод
    private int money; // сколько переводить
    private Account srcRun; // с какого аккаунта осуществлять перевод
    private Account dstRun; // на какой аккаунт осуществлять перевод
    private int moneyRun; // сколько переводить

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }


    @Override
    public void run() {

        // TODO: перевод средств в количестве (money) с аккаунта (src) на аккаунт (dst)
        if (src.getId() < dst.getId()) {
            srcRun = src;
            dstRun = dst;
            moneyRun = money;
        } else {
            srcRun = dst;
            dstRun = src;
            moneyRun = -1 * money;
        }
        synchronized (srcRun) {
            srcRun.setBalance(srcRun.getBalance() - moneyRun);
            System.out.println("Account = " + srcRun.getId() + " Balance = " + srcRun.getBalance());
            synchronized (dstRun) {
                dstRun.setBalance(dstRun.getBalance() + moneyRun);
                System.out.println("Account = " + dstRun.getId() + " Balance = " + dstRun.getBalance());
            }
        }
    }
}