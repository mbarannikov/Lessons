package ru.ifmo.base.lesson7;

abstract public class BattleUnit extends Unit implements CanAttack{
//    расширяет Unit, множественное наследование запрещено
//    обязан реализовать все методы интерфейса
//    у абстрактных классов могут быть методы без реализации и их нельзя объявлять
public int attackScore;
//    abstract public void attack(BattleUnit enemy); нет реализации

    public BattleUnit(int healthScore, int speed, int attackScore) {
        super(healthScore, speed); // вызов конструктора родительского класса
        setAttackScore(attackScore);
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }

    @Override
    public void runFromField() {
        System.out.println("BattleUnit runFromField CanAttack");
    }

    public static BattleUnit getBattleUnit(String type){
        BattleUnit battleUnit = null;
        if ("knight".equals(type)){
            battleUnit = new Knight(
                    (int)(Math.random()*10+2) /*2-12*/,
                    (int)(Math.random()*7+1)/*1-8*/,
                    (int)(Math.random()*8+1)/*1-9*/,
                    (int)(Math.random()*13+3)/*3-16*/
            );
        }else if ("doctor".equals(type)){
            battleUnit = new Doctor(
                    (int)(Math.random()*10+2) /*2-12*/,
                    (int)(Math.random()*7+1)/*1-8*/,
                    (int)(Math.random()*8+1)/*1-9*/,
                    (int)(Math.random()*13+3)/*3-16*/
            );
        }else if ("infantry".equals(type)){
            battleUnit = new Infantry(
                    (int)(Math.random()*10+2) /*2-12*/,
                    (int)(Math.random()*7+1)/*1-8*/,
                    (int)(Math.random()*8+1)/*1-9*/,
                    (int)(Math.random()*13+3)/*3-16*/
            );
        }
        return battleUnit;
    }

}
