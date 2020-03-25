package ru.ifmo.base.animals;

public class Mouse implements CanBeEaten {

    @Override
    public void beEat(CanEat animal) {
        System.out.println("Съедина"+ animal);
    }

}
