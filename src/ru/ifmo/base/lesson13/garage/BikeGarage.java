package ru.ifmo.base.lesson13.garage;

public class BikeGarage extends Garage<Bus> {
    public  void checkBike(){
        System.out.println(this.getCarOnService().isWiFi());
    }
}

class BikeGarage2 extends Garage<Transport>{
    public  void checkBike(){
        System.out.println(this.getCarOnService().getNum());
    }
}

class BikeGarage3<T> extends Garage{
    private T manager;
    public  void checkBike(){
        System.out.println(this.getCarOnService().getNum());
    }
}