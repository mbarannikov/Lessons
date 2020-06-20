package ru.ifmo.base.lesson24.sync;



public class SynchronizedProblem {

    public static void main(String[] args) {

        Object object1 = new Object();
        Object object2 = new Object();

        Thread thread1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " запущен...");
            synchronized (object2) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " работает с object2");
                synchronized (object1) {
                    System.out.println(Thread.currentThread().getName() + " работает с object1");
                }
            }
        });
        Thread thread2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " запущен...");
            synchronized (object2) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " работает с object2");
                synchronized (object1) {
                    System.out.println(Thread.currentThread().getName() + " работает с object1");
                }
            }
        });
        thread1.start();
        thread2.start();

    }

}