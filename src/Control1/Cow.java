package Control1;

public class Cow extends FarmAnimal implements CanGiveMeat, CanGiveRes {

    public Cow(String name, int weight, int speed, int health, int res) {
        super(name, weight, speed, health, res);
    }
}
