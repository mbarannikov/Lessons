package ru.ifmo.base.lesson25;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public  class DelayQ{
    public static void main(String[] args) {

        DelayQueue<Action> actions = new DelayQueue<>();
        actions.put(new Action(LocalDateTime.now(),() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("NOW");
        }));

        actions.put(new Action(LocalDateTime.now().minusMinutes(4),() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("OLD TASK");
        }));

        actions.put(new Action(LocalDateTime.now().plusMinutes(1),() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("FUTURE TASK 1");
        }));

        actions.put(new Action(LocalDateTime.now().plusMinutes(2),() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("FUTURE TASK 2");
        }));

        while (true){
            try {
                new Thread(actions.take().getRunnable()).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Action implements Delayed{
    private LocalDateTime dateTime;
    private Runnable runnable;

    public Runnable getRunnable() {
        return runnable;
    }

    public Action(LocalDateTime dateTime, Runnable runnable) {
        this.dateTime = dateTime;
        this.runnable = runnable;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        // разрешено возвращать объект из очереди или нет
        return unit.convert(
                Duration.between(LocalDateTime.now(), dateTime).toSeconds(),
                TimeUnit.SECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        // порядок сортировки элементов
        return dateTime.compareTo(((Action)o).dateTime);
    }
}
