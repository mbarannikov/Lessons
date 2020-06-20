package ru.ifmo.base.lesson24;

public class YieldV {
    public static void main(String[] args) {
        new Thread(new PrintThread()).start();
        new Thread(new PrintThread()).start();


    }
}

class PrintThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread = " + Thread.currentThread().getName());
            Thread.yield(); //поток готов освободить место одному потоку и встать в очередь на выполнение
            //System.out.println("Thread = " + Thread.currentThread().getState());
        }
    }
}
