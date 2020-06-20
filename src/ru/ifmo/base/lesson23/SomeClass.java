package ru.ifmo.base.lesson23;

import java.util.ArrayList;
import java.util.Scanner;

public class SomeClass {
    public static void main(String[] args) {
        EventListener firstListener = new EventListener() {
            @Override
            public void greenEvent(int code) {

                System.out.println("Реакция на firstListener = " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("Реакция на firstListener " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("Реакция на firstListener " + code);
            }
        };

        EventListener secondListener = new EventListener() {
            @Override
            public void greenEvent(int code) {

                System.out.println("Реакция на secondListener " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("Реакция на secondListener " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("Реакция на secondListener " + code);
            }
        };

        System.out.println(firstListener.getClass().getName());
        System.out.println(secondListener.getClass().getName());
        System.out.println(secondListener.getClass().getSuperclass().getName());

        StateClass stateClass = new StateClass();
        stateClass.addListener(firstListener);
        stateClass.addListener(secondListener);

        Scanner scanner = new Scanner(System.in);
        String s;
        while (true){
            System.out.println("input status or exit for quit");
            s = scanner.nextLine();
            if("exit".equalsIgnoreCase(s))break;
            stateClass.changeState(s);
        }
    }
}

interface EventListener{
    void greenEvent(int code);
    void yellowEvent(int code);
    void redEvent(int code);
}

class StateClass{
    private ArrayList<EventListener> eventListeners = new ArrayList<>();
    public void addListener(EventListener listener){
        eventListeners.add(listener);
    }
    public void removeListener(EventListener listener){
        eventListeners.remove(listener);
    }

    private void okNotify(int code){
        eventListeners.forEach(listener -> listener.greenEvent(code));
    }
    private void warnNotify(int code){
        eventListeners.forEach(listener -> listener.yellowEvent(code));
    }
    private void errorNotify(int code){
        eventListeners.forEach(listener -> listener.redEvent(code));
    }
    public void changeState(String value){
        if ("ok".equalsIgnoreCase(value)) okNotify(1);
        if ("warn".equalsIgnoreCase(value)) warnNotify(5);
        if ("error".equalsIgnoreCase(value)) errorNotify(10);
    }
}