package ru.ifmo.base.lesson24.sync;


import java.util.ArrayList;

public class Synchronized {
    public static void main(String[] args) {
        Counter counter = new Counter();

        ArrayList<IncrementThread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new IncrementThread(counter));
        }

        for (IncrementThread thread: threads){
            thread.start();
        }

       for (IncrementThread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("counter: " + counter.getCounter());


    }
}

class Counter {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public
//    public synchronized
    void increment(){
        counter++;
    }
}

class IncrementThread extends Thread{
    private final Counter counter;

    public IncrementThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            synchronized (counter) {
                counter.increment();
            }
        }
    }
}