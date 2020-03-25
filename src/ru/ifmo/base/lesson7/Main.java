package ru.ifmo.base.lesson7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип первого юнита");
//        вызов статических методов осуществляется по имени класса
        BattleUnit unit1 = BattleUnit.getBattleUnit(scanner.nextLine());
        System.out.println("Введите тип второго юнита");
        BattleUnit unit2 = BattleUnit.getBattleUnit(scanner.nextLine());
//        BattleUnit unit3 = BattleUnit.getBattleUnit("doctor");
        System.out.println(unit2.healthScore);
        unit1.attack(unit2);
        System.out.println(unit2.healthScore);
    }
}
