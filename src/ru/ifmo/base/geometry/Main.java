package ru.ifmo.base.geometry;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(9);
        System.out.println(circle.getRadius());
        float per = circle.getPerimeter();
        System.out.println(per);
        float sur = circle.getSurface();
        System.out.println(sur);
    }
}
