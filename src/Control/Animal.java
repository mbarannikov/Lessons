package Control;


abstract public class Animal {
    String name;
    int weight;
    int speed;

    public Animal(String name, int weight, int speed) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
