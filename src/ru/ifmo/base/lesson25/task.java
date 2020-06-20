package ru.ifmo.base.lesson25;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

//заказ
//
//        Потоки:
//        Клиент формирует заказ (создает объект)
//        передает в очередь 1 / забирает готовый из очереди 3
//        Официант
//        забирает из очереди 1 и передает в очередь 2
//        Повар
//        забирает из очереди 2 и передает в очередь 3
//
//        Очереди:
//        1 клиент-официант
//        2 официант-повар
//        3 повар-клиент

public class task {

    public static void main(String[] args) {

        LinkedBlockingDeque<Order> clientWaiter = new LinkedBlockingDeque<>(20);
        LinkedBlockingDeque<Order> waiterCook = new LinkedBlockingDeque<>(20);
        LinkedBlockingDeque<Order> cookClient = new LinkedBlockingDeque<>(20);

        new Thread(new Client(clientWaiter, cookClient)).start();
        new Thread(new Waiter(clientWaiter, waiterCook)).start();
        new Thread(new Cook(waiterCook, cookClient)).start();

    }

}

class Client implements Runnable {
    private LinkedBlockingDeque<Order> clientWaiter;
    private LinkedBlockingDeque<Order> cookClient;

    public Client(LinkedBlockingDeque<Order> clientWaiter, LinkedBlockingDeque<Order> cookClient) {
        this.clientWaiter = clientWaiter;
        this.cookClient = cookClient;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Client " + Thread.currentThread().getState());
            try {
                Thread.sleep(5000);
                Order order = Order.getOrder();
                clientWaiter.put(order);
                System.out.println("Client make " + order);
                System.out.println("Client get " + cookClient.take());
            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class Waiter implements Runnable {
    private LinkedBlockingDeque<Order> clientWaiter;
    private LinkedBlockingDeque<Order> waiterCook;

    public Waiter(LinkedBlockingDeque<Order> clientWaiter, LinkedBlockingDeque<Order> waiterCook) {
        this.clientWaiter = clientWaiter;
        this.waiterCook = waiterCook;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Waiter " + Thread.currentThread().getState());
            try {
                Thread.sleep(5000);
                Order order = clientWaiter.take();
                waiterCook.put(order);
                System.out.println("Waiter served " + order);
            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class Cook implements Runnable {
    private LinkedBlockingDeque<Order> cookClient;
    private LinkedBlockingDeque<Order> waiterCook;

    public Cook(LinkedBlockingDeque<Order> waiterCook, LinkedBlockingDeque<Order> cookClient) {
        this.cookClient = cookClient;
        this.waiterCook = waiterCook;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Cook " + Thread.currentThread().getState());
            try {
                Thread.sleep(5000);
                Order order = waiterCook.take();
                cookClient.put(order);
                System.out.println("Cooked  " + order);
            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class Order {

    private int tableCode;

    public Order(int tableCode) {
        this.tableCode = tableCode;
    }

    public int getTableCode() {
        return tableCode;
    }

    public void setTableCode(int tableCode) {
        this.tableCode = tableCode;
    }

    @Override
    public String toString() {
        return "Order{" +
                "tableCode=" + tableCode +
                '}';
    }

    public static Order getOrder(){
        Random random = new Random();
        return new Order(random.nextInt(30));
    }
}
