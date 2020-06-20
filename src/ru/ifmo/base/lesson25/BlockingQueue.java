package ru.ifmo.base.lesson25;

import Fintess.Single;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

public class BlockingQueue {
    public static void main(String[] args) {
        // put -> [20] -> get
        // put - take // with wait
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(10);
        ArrayBlockingQueue<String> strings2 =
                new ArrayBlockingQueue<>(10, true);

        LinkedBlockingQueue linkedBlockingQueue;
        LinkedBlockingDeque linkedBlockingDeque;
        LinkedBlockingDeque<Signal> signals = new LinkedBlockingDeque<>(5);

        SynchronousQueue synchronousQueue; // каждая операция добавления находится в ожидании операции удаления
        DelayQueue delayQueue;


        new Thread(new GetSignal(signals)).start();
        new Thread(new PutSignal(signals)).start();
        new Thread(new PutSignal(signals)).start();


    }
}

class PutSignal implements Runnable{
    private LinkedBlockingDeque<Signal> signals;

    public PutSignal(LinkedBlockingDeque<Signal> signals) {
        this.signals = signals;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("PutSignal " + Thread.currentThread().getState());
            try {
                Thread.sleep(4000);
                Signal signal = Signal.getSignal();
                signals.put(signal);
                System.out.println("PutSignal" + signal);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class GetSignal implements Runnable{
    private LinkedBlockingDeque<Signal> signals;

    public GetSignal(LinkedBlockingDeque<Signal> signals) {
        this.signals = signals;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("GetSignal " + Thread.currentThread().getState());
            try {
                System.out.println("GetSignal " + signals.take()); // заставит поток ждать
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

        }
    }
}

class Signal {
    enum Priority {
        HIGH, MEDIUM, LOW;
        public static Priority getPriority(int ord){
            for (Priority priority: values()){
                if (ord == priority.ordinal()){
                    return priority;
                }
            }
            throw new AssertionError("wrong ordinal");
        }
    }

    private Priority priority;
    private int code;

    public Signal(Priority priority, int code) {
        this.priority = priority;
        this.code = code;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "priority=" + priority +
                ", code=" + code +
                '}';
    }

    public static Signal getSignal(){
        Random random = new Random();
        return new Signal(
                Priority.getPriority(random.nextInt(Priority.values().length)),
                random.nextInt(30)
        );
    }
}