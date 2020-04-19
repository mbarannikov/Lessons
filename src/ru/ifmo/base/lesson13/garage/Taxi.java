package ru.ifmo.base.lesson13.garage;

public class Taxi extends Bus implements someInterf{
    private String type;

    public Taxi(String departureSt, String destSt, String num, boolean wiFi, String type) {
        super(departureSt, destSt, num, wiFi);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void repair() {
        System.out.println("Ремонт такси");
    }

    @Override
    public void someMethod() {
            System.out.println("Метод такси");
    }
}
