package ru.ifmo.base.lesson26;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadsPool {
    public static void main(String[] args) {

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            fixedPool.execute(new RunnableTask("fixedPool"));
        }
        fixedPool.shutdown();
    //    List<Runnable> runnables = fixedPool.shutdownNow();
    //    System.out.println(runnables);
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new RunnableTask("singleThread1"));
        singleThread.execute(new RunnableTask("singleThread2"));
        singleThread.shutdown();
// Отложенное выполнение
        ScheduledExecutorService poolD =
                Executors.newSingleThreadScheduledExecutor();
        poolD.schedule(
                new RunnableTask("poolD"),
                5,
                TimeUnit.SECONDS
        );
        poolD.shutdown();

        ScheduledExecutorService everyFiveSecondAfterStart =
                Executors.newSingleThreadScheduledExecutor();
        everyFiveSecondAfterStart.scheduleAtFixedRate(
                new RunnableTask("everyFiveSecondAfterStart"),
                0,
                5,
                TimeUnit.SECONDS
        );
        ScheduledExecutorService everyFiveSecondAfterEnd =
                Executors.newSingleThreadScheduledExecutor();
        everyFiveSecondAfterEnd.scheduleWithFixedDelay(
                new RunnableTask("everyFiveSecondAfterEnd"),
                0,
                5,
                TimeUnit.SECONDS
        );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        everyFiveSecondAfterStart.shutdown();
        everyFiveSecondAfterEnd.shutdown();

    }
}

class RunnableTask implements Runnable{
    private String poolName;

    public RunnableTask(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public void run() { // вся логика работы потока
        System.out.println("Поток " + Thread.currentThread().getName() +
                " из пула " + poolName);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Заверщение");
    }
}