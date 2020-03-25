package ru.ifmo.base.lesson7;

public class King extends Unit {
    private String Gold;

    public King(int healthScore, int speed, String Gold) {
        super(healthScore, speed);
        setGold(Gold);
    }

    public void setGold(String gold) {
        Gold = gold;
    }

    public String getGold() {
        return Gold;
    }

    @Override
    public void rest() {
        System.out.println("King rest");
    }
}
