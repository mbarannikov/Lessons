package ru.ifmo.base.animals;

public class Main {
    public static void main(String[] args) {
        CanBeEaten mouse = new Mouse();
        CanEat wolf = new Wolf();
        mouse.beEat(wolf);
    }
}
