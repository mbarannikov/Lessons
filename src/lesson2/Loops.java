package lesson2;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int programNum = (int) (Math.random() * 6) + 1;
//        while (true) {
//            System.out.println("Введите число от 1 до 6");
//            break;
//            int num = in.nextInt();
//            if (num == 0) {
//                System.out.println("Выход из программы");
//                break;
//            } else if (num == programNum) {
//                System.out.println("Вы угадали");
//                break;
//            } else if (num < programNum) {
//                System.out.println("Загаданное число больше");
//            } else if (num > programNum) {
//                System.out.println("Загаданное число меньше");
//            } else {
//                System.out.println("Попробуйте еще раз");
//
//            }
//
//        }

        for (int i = 0; i <=9; i++) {
            if(i%2!=0) continue;
            System.out.println(i);
        }
    }
}
