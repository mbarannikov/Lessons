package ru.ifmo.base.lesson13.garage;

public class TstGarage {
    public static void main(String[] args) {
        Bus bus = new Bus("Спб", "Тверь", "234", false);
        Train train = new Train("Спб", "Москва", "23-Ф", 12);
        Taxi taxi = new Taxi("Спб", "Тверь", "567", false, "VIP");

        Garage<Bus> garage1 = new Garage<>();
        garage1.setCarOnService(bus);
        System.out.println(garage1.getCarOnService().isWiFi());
        Garage<Train> garage2 = new Garage<>();
        garage2.setCarOnService(train);
        System.out.println(garage2.getCarOnService().getCarCount());

        Garage<Transport> garage3 = new Garage<>();
        garage3.setCarOnService(bus);
        garage3.setCarOnService(train);
        System.out.println(garage3.getCarOnService().getDepartureSt());

        Garage<Taxi> garage4 = new Garage<>();
        garage4.setCarOnService(taxi);
        System.out.println(garage4.getCarOnService().getType());

        BikeGarage garage5 = new BikeGarage();
        garage5.setCarOnService(bus);
        garage5.checkBike();
        BikeGarage2 garage6 = new BikeGarage2();
        garage6.setCarOnService(bus);
        garage6.checkBike();
        BikeGarage3<Taxi> garage7 = new BikeGarage3();
        garage7.setCarOnService(taxi);
        garage7.checkBike();
    }
}
