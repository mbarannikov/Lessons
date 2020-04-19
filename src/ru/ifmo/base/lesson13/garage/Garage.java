package ru.ifmo.base.lesson13.garage;

public class Garage<T extends Transport & Repairing> {
    private T carOnService;

    public T getCarOnService() {
        return carOnService;
    }

    public void setCarOnService(T carOnService) {
        this.carOnService = carOnService;
    }

    public void service(){
        carOnService.repair();
    }

//    public void someFunc(){
//        carOnService.someMethod();
//    }
}
