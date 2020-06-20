package ru.ifmo.base.lesson26;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService unitPool = Executors.newFixedThreadPool(3);
        Callable<Unit> unitCallable = new UnitCreator();

        ArrayList<Future<Unit>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Unit> future = unitPool.submit(unitCallable);
            futures.add(future);
        }
        unitPool.shutdown();
        //unitPool.shutdown();
//        for (Future<Unit> future: futures
//             ) {
//            System.out.println("Waiting Future...");
//            try {
//                System.out.println("Unit " + future.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//
//        }

        for (Future<Unit> future: futures
        ) {
            System.out.println("Waiting Future...");
                try {
                    System.out.println("Unit " + future.get(
                            (long) (Math.random()*3000),
                            TimeUnit.MILLISECONDS
                    ));
                }catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                } catch (TimeoutException e) {
                    System.out.println("--- не смог дождаться юнита ---");
               //     e.printStackTrace();
                }
        }

        System.out.println("--- unitPool 2 ---");
        ExecutorService unitPool2 = Executors.newFixedThreadPool(3);
        List<Callable<Unit>> unitTasks = new ArrayList<>();
        unitTasks.add(unitCallable);
        unitTasks.add(unitCallable);
        unitTasks.add(unitCallable);
        unitTasks.add(unitCallable);
        unitTasks.add(unitCallable);
        unitTasks.add(unitCallable);
        unitTasks.add(unitCallable);

        try {
            List<Future<Unit>> futureList = unitPool2.invokeAll(unitTasks);
            unitPool2.shutdown();
            for (Future<Unit> future: futureList
                 ) {
                System.out.println("Unit " + future.get());
                System.out.println(future.cancel(true)); // отменяет задачу
                System.out.println(future.isCancelled()); //  отменяет задачу
                System.out.println(future.isDone()); // завершена ли задача
//                while (){
//
//                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}

class UnitCreator implements Callable<Unit> {
    @Override
    public Unit call() throws Exception {
        Thread.sleep(new Random().nextInt(5000));
        Unit unit = new Unit();
        unit.setName(Thread.currentThread().getName());
        unit.setHealth(new Random().nextInt(20)+1);
        unit.setAttack(new Random().nextInt(15)+1);
        return unit;
    }
}

class Unit {
    private String name;
    private int health;
    private int attack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                '}';
    }
}
