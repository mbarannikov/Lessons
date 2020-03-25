package ru.ifmo.base.animals;

public class Wolf implements CanEat {
    @Override
    public void eat(CanBeEaten animal) {
        System.out.println("Съел"+animal);
    }
}
