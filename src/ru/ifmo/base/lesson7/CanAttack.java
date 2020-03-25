package ru.ifmo.base.lesson7;

public interface CanAttack {
//    на основе интерфейса нельзя создать объект
//    до 8 версии только методы без реализации
    void attack(BattleUnit enemy);
    default void runFromField(){
        System.out.println("runFromField CanAttack");
    }
}
