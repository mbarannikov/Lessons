package Control;
//На Ферме есть фермер, домашние животные (и птицы). Максимальное количество животных (и птиц) на ферме - 10.
//
//        Фермер живет за счет ресурсов, собираемых с животных. Изначально фермер создается с 5 единицами ресурсов.
//        Фермер должен иметь возможность:
//        1. собрать ресурсы с домашних животных, которые могут давать ресурсы
//        2. съесть домашнее животное, которое пригодно в пищу (когда на ферме не останется животных, которые дают ресурсы). При этом расчет ресурсов следующий: 1кг животного -  1 единица ресурса
//        3. прогнать дикое животное, которое пришло на ферму
//        4. кормить домашнее животное
public class Farmer {
    public int getHealth() {
        return health;
    }

    String name;
    int health;
    public void kickout(WildAnimal animal){
        if(animal.farmAttackCount<3){
            animal.farmAttackCount++;
            System.out.println("Фермер прогнал"+animal.name);
        }

    }
    public void fead(FarmAnimal[] animals){
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].getHealth() < animals[i].getMaxHealth()&&animals[i].isOnFarm()) {
                animals[i].health++;
                System.out.println("Фермер кормит животное"+animals[i].getName());
            }
        }
    }

    public void takeRes(FarmAnimal[] animals) {
        boolean flag = false;
        for (int i = 0; i < animals.length; i++) {
            if ((animals[i] instanceof CanGiveRes)&&animals[i].isOnFarm()) {
                    while (getHealth() < 5 && animals[i].getRes() > 0) {
                        this.health++;
                        animals[i].res--;
                        flag = true;
                }
                    if(flag){System.out.println("Фермер собрал ресурс у"+animals[i].getName());}
            }
        }
    }

    public void takeMeat(FarmAnimal[] animals) {
        boolean flag = false;
        for (int i = 0; i < animals.length; i++) {
            if ((animals[i] instanceof CanGiveMeat)&&animals[i].isOnFarm()) {
                while (getHealth() < 5 && animals[i].getWeight() > 0) {
                    this.health++;
                    animals[i].weight--;
                    flag = true;
                }
                if(flag) {
                    animals[i].setOnFarm(false);
                    System.out.println("Фермер съел " + animals[i].getName());
                }
            }
        }
    }

}
