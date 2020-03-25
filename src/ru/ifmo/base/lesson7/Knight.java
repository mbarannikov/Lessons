package ru.ifmo.base.lesson7;

public class Knight extends BattleUnit{
    private int horseSpeed;

    public Knight(int healthScore, int speed, int attackScore, int horseSpeed) {
        super(healthScore, speed, attackScore);
        setHorseSpeed(horseSpeed);
    }

    public void setHorseSpeed(int horseSpeed) {
        this.horseSpeed = horseSpeed;
    }

    public int getHorseSpeed() {
        return horseSpeed;
    }

    @Override
    public void attack(BattleUnit enemy) {
        System.out.println("Knight attack");
    }

    @Override
    public void rest() {
        System.out.println("Knight rest");
    }
}
