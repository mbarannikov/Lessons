package ru.ifmo.base.lesson7;

abstract public class Unit implements CanRest{
//    при наследовании все дочернии классы получают все свойства и методы родительского класса
    protected int healthScore; // доступен всем дочерним классам плюс внутри пакета
    protected String name = "Unit";
    protected int speed;

    public Unit(int healthScore, int speed) {
        setHealthScore(healthScore);
        setSpeed(speed);
    }

    public void setHealthScore(int healthScore) {
        this.healthScore = healthScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealthScore() {
        return healthScore;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isAlive(){
        return healthScore > 0;
    }

    public void run(){
        System.out.println(name +"двигается со скоростью" + speed);
    }


}
