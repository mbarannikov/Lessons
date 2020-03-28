package Control1;

public class Chicken extends FarmAnimal implements CanGiveMeat, CanGiveRes {

    public Chicken(String name, int weight, int speed, int health, int res) {
        super(name, weight, speed, health, res);
    }
}
