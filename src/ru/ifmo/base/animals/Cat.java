package ru.ifmo.base.animals;

public class Cat implements CanEat,CanBeEaten {
    @Override
    public void beEat(CanEat animal) {
        System.out.println("Съедина"+ animal);
    }

    @Override
    public void eat(CanBeEaten animal) {
        System.out.println("Съел"+animal);
    }
}
