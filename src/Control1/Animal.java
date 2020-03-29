package Control1;


abstract public class Animal {
    private String name;
    private int weight;
    private int speed;

    public Animal(String name, int weight, int speed) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public void decWeight(int cnt) {
        if(weight>0)this.weight -= cnt;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }

}
