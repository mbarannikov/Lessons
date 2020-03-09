package lesson2;

import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int num = in.nextInt();
/*        if (num >= 0 && num <= 14) {
            System.out.println("Первая четверть");
        } else if (num >= 15 && num <= 30) {
            System.out.println("Вторая четверть");
        } else if (num >= 31 && num <= 45) {
            System.out.println("Третья четверть");
        } else if (num >= 46 && num <= 59) {
            System.out.println("Четвертая четверть");
        } else {
            System.out.printf("Вы ввели число не из диапазона %d\n", num);
        }*/
/*        switch (num) {
            case 111,222,333-> System.out.println("Малый приз");
            case 444, 555-> System.out.println("Средний приз");
            case 777->  System.out.println("Крупный приз");
            default->                System.out.println("Попробуйте еще раз");

        }*/
        String prize = switch (num) {
            case 111, 222, 333 -> "Малый приз";
            case 444, 555 -> "Средний приз";
            case 777 -> "Крупный приз";
            default -> {
                String someRes = "Попробуйте еще раз";
                yield someRes;
            }
        };
    }
}
