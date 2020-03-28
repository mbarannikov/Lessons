package Control1;
//Домашние животные: Корова, Кот, Курица, Кролик
//        обладают следующими характеристиками:
//        имя, вес, скорость, здоровье, количество ресурсов (у каждого свое и 0, если животное на дает ресурс)
//        Есть домашние животные, которые дают ресурсы:  Корова, Курица
//        Есть домашние животные, которые пригодны в пищу: Кролик, Корова, Курица
//        Домашнее животное может убежать от дикого животного, если его скорость больше.
//        Домашнее животное может восполнять здоровье (+1, но не больше изначального).
//        Животные восполняют здоровье во время кормления.

public class FarmAnimal extends Animal implements CanGiveMeat {
    private int health;
    private int maxHealth;
    private int res;
    private boolean onFarm;

    public FarmAnimal(String name, int weight, int speed, int health, int res) {
        super(name, weight, speed);
        this.health = health;
        this.res = res;
        this.maxHealth = health;
        setOnFarm(true);
    }

    public boolean isOnFarm() {
        return onFarm;
    }

    public void setOnFarm(boolean onFarm) {
        this.onFarm = onFarm;
    }

    public int getRes() {
        return res;
    }

    public void decRes(int cnt) {
        if(res>0)this.res -= cnt;
    }

    public void eat() {
        if(health<maxHealth) {
            health++;
            System.out.println("Животное "+getName()+" покормили. Осталось здоровья "+health);
        }
    }

    public void attacked(int strength) {
        health-=strength;
        if (health<0){
            setOnFarm(false);
            System.out.println("Животное "+getName()+" съели");
        }

    }


}
