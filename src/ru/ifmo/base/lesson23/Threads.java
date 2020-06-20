package ru.ifmo.base.lesson23;

public class Threads {
    public static void main(String[] args) {
        // Варианты описания потоков и их инструкций
        // 1. создание класса, который наследуется от класса Thread

        FirstThread firstThread = new FirstThread();
        System.out.println(firstThread.getName() +
                ": " + firstThread.getState());
        firstThread.start();
        System.out.println(firstThread.getName() +
                ": " + firstThread.getState());

        System.out.println("Основной поток " + Thread.currentThread().getName());

        SecondThread secondNotThread = new SecondThread(); //not thread
        Thread secondThread = new Thread(new SecondThread());
        secondThread.start();
        System.out.println("secondThread = " + secondThread.getName() +
                ": " + secondThread.getState());

        Thread thirdThread = new Thread(() -> {
            System.out.println("thirdThread isAlive " + Thread.currentThread().getName());
        });
        thirdThread.start();

        Thread threadOne= new Thread(new SecondThread());
        Thread threadTwo= new Thread(new SecondThread());
        Thread threadThree= new Thread(new SecondThread());


        System.out.println("Thread group threadOne = " + threadOne.getThreadGroup());
        System.out.println("Max priority threadOne = " + threadOne.getThreadGroup().getMaxPriority());
        threadOne.setPriority(Thread.MIN_PRIORITY);
        threadTwo.setPriority(Thread.NORM_PRIORITY);
        threadThree.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Max priority threadOne = " + threadOne.getThreadGroup().getMaxPriority());

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        try {
            System.out.println("Основной поток " + Thread.currentThread().getName() +
                    ": " + Thread.currentThread().getState());
            threadOne.join();
            threadTwo.join();
            threadThree.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Основной поток " + Thread.currentThread().getName() +
                ": " + Thread.currentThread().getState());

        FirstThread daemon = new FirstThread();
        daemon.setDaemon(true);
        Thread actions = new Thread(() ->{
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("some actions...");
                try {
                    System.out.println("222"+Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
            System.out.println("After While");
        });
        actions.start();
        try {
            System.out.println("111"+Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.interrupt();


    }
}

// первый вариант - создание класса, который наследуется от класса Thread
class FirstThread extends Thread{

    @Override
    public void run(){ // инструкции потока
        // когда метод run будет вызван
        // инструкции начнут выполняться в отдельном потоке
        // ()

        Thread.currentThread().setName("FirstThread");
        System.out.println(Thread.currentThread().getName() +
                ": " + Thread.currentThread().getState());

    }

}

class SecondThread implements Runnable{
    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

