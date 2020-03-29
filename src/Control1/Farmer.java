package Control1;
//На Ферме есть фермер, домашние животные (и птицы). Максимальное количество животных (и птиц) на ферме - 10.
//
//        Фермер живет за счет ресурсов, собираемых с животных. Изначально фермер создается с 5 единицами ресурсов.
//        Фермер должен иметь возможность:
//        1. собрать ресурсы с домашних животных, которые могут давать ресурсы
//        2. съесть домашнее животное, которое пригодно в пищу (когда на ферме не останется животных, которые дают ресурсы). При этом расчет ресурсов следующий: 1кг животного -  1 единица ресурса
//        3. прогнать дикое животное, которое пришло на ферму
//        4. кормить домашнее животное
public class Farmer {
    private String name;
    private final int maxHealth;
    private int health;

    public Farmer(String name) {
        this.name = name;
        this.maxHealth = 5;
        this.health = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void decrHealth(int cnt) {
        this.health -= cnt ;
    }

    public void takeRes(FarmAnimal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            if ((animals[i] instanceof CanGiveRes)&&animals[i].isOnFarm()) {
                    while (getHealth() < getMaxHealth() && animals[i].getRes() > 0) {
                        health++;
                        animals[i].decRes(1);
                        System.out.println("Фермер собрал ресурс у "+animals[i].getName());
                }
            }
        }
    }

    public void takeMeat(FarmAnimal[] animals) {
        boolean flag = false;
        for (int i = 0; i < animals.length; i++) {
            if ((animals[i] instanceof CanGiveMeat)&&animals[i].isOnFarm()) {
                while (health< maxHealth && animals[i].getWeight() > 0) {
                    health++;
                    animals[i].decWeight(1);
                    flag = true;
                }
                if(flag) {
                    animals[i].setOnFarm(false);
                    System.out.println("Фермер съел " + animals[i].getName());
                    flag = false;
                }
            }
        }
    }

    public void fead(FarmAnimal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].isOnFarm()){
                animals[i].eat();
            }
        }
    }
}
