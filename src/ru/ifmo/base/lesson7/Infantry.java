package ru.ifmo.base.lesson7;

public class Infantry extends BattleUnit{
    private int armor;

    public Infantry(int healthScore, int speed, int attackScore, int armor) {
        super(healthScore, speed, attackScore);
        setArmor(armor);
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    @Override
    public void attack(BattleUnit enemy) {
        System.out.println("Infantry attack");
    }

    @Override
    public void rest() {
        System.out.println("Infantry rest");
    }
}
