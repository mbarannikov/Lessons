package ru.ifmo.base.lesson11.gc;

public class TstMessage {

    public static void main(String[] args) {
//        stack вызовов работает по принципу LIFO
//        1.main(10-), data, num, message pointer
//        2.printStart(5-)
//        3.println(4-)
//        6.setText(7-)
//        8.setCode(9-)
//        heap
//        1.new Message
//        2.
//        3.

        String data = "Срочное сообщение";
        int num = 10;

        printStart();

        Message message = new Message();
        message.setText(data);
        message.setCode(num);

    }

    private static void printStart(){
        System.out.println("START");
        Message message = new Message();
        message = new Message();
        message = null;
    }
}
