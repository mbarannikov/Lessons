package Control;
//Домашние животные: Корова, Кот, Курица, Кролик
//        обладают следующими характеристиками:
//        имя, вес, скорость, здоровье, количество ресурсов (у каждого свое и 0, если животное на дает ресурс)
//        Есть домашние животные, которые дают ресурсы:  Корова, Курица
//        Есть домашние животные, которые пригодны в пищу: Кролик, Корова, Курица
//        Домашнее животное может убежать от дикого животного, если его скорость больше.
//        Домашнее животное может восполнять здоровье (+1, но не больше изначального).
//        Животные восполняют здоровье во время кормления.

public class FarmAnimal extends Animal implements CanGiveMeat {
    int health;
    int maxHealth;
    int res;
    boolean onFarm;

    public boolean isOnFarm() {
        return onFarm;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public FarmAnimal(String name, int weight, int speed, int health, int res) {
        super(name, weight, speed);
        this.health = health;
        this.res = res;
        this.maxHealth = health;
    }

    public void setOnFarm(boolean onFarm) {
        this.onFarm = onFarm;
    }

    public int getRes() {
        return res;
    }


}
