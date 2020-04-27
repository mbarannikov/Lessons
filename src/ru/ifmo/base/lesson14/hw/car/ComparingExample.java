package ru.ifmo.base.lesson14.hw.car;
import java.util.ArrayList;
import java.util.Comparator;

public class ComparingExample {
    public static void main(String[] args) {
        // Дополнительное домашнее задание
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 1900);

        // Объекты добавить в ArrayList cars
        ArrayList<Car> carArrayList = new ArrayList<>(20);
        carArrayList.add(blackOpel);
        carArrayList.add(redOpel);
        carArrayList.add(yellowMazda);
        carArrayList.add(greenMazda);
        System.out.println(carArrayList);

        // отсортировать объекты в cars сначала по brand, price, color
        // cars.sort(компаратор);
        Comparator<Car> carComparator = new CarBrandComparator().thenComparing(new CarPriceComparator()).thenComparing(new CarColorComparator());
        carArrayList.sort(carComparator);
        System.out.println(carArrayList);


    }
}
