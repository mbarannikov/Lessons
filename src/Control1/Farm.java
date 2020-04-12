package Control1;

import java.util.NavigableMap;

//День на ферме (метод passDay):
//        1. Фермер тратит 2 единицы ресурсов (если ресурсов не осталось, игра заканчивается).
//        2. Приходит дикое животное (выбирается рандомно из массива с дикими животными), пытается поймать (съесть, либо ранить) домашнее животное (выбирается рандомно). Если домашнее животное убежало, дикое уходит ни с чем.
//        3. Иногда (рандомно) фермер может прогнать дикое животное.
//        4. Фермер кормит всех животных (животные восполняют здоровье)
//        5. Фермер собирает ресурсы с животных, с которых можно их собирать. Если таких не осталось, съедает животное, пригодное в пищу (если такие остались).
public class Farm {
    private Farmer farmer;
    private FarmAnimal[] farmAnimals = new FarmAnimal[4];
    private final String TITLE;

    public Farm(String TITLE, Farmer farmer) {
        this.TITLE = TITLE;
        this.farmer = farmer;
    }

    public void addFarmAnimal(FarmAnimal fa) {
        for (int i = 0; i < farmAnimals.length; i++) {
            if (farmAnimals[i] == null) {
                farmAnimals[i] = fa;
                return;
            }
        }
    }

    public void dayOnFarm(Nature nature) {
        int i = 1;
        WildAnimal[] wildAnimals = nature.getWildAnimals();
        for (FarmAnimal fa : farmAnimals
        ) {
            System.out.println(fa.toString());
        }
        for (WildAnimal wa : wildAnimals
        ) {
            System.out.println(wa.toString());
        }
        while (farmer.getHealth() > 0) {
            System.out.println("Наступил " + i + " день");
            System.out.println("Здоровье фермера " + farmer.getHealth());
            int randWild = (int) (Math.random() * wildAnimals.length);
            int randWildKick = (int) (Math.random() * wildAnimals.length);
            int randFarmAttack = (int) (Math.random() * farmAnimals.length);

            farmer.decrHealth(2);
            if (randWild == randWildKick) wildAnimals[randWild].kicked();
            else wildAnimals[randWild].attackFarm(farmAnimals, randFarmAttack);
            farmer.fead(farmAnimals);
            farmer.takeRes(farmAnimals);
            farmer.takeMeat(farmAnimals);
            i++;
            if (i > 100) return; // если ошибка
        }

        System.out.println("Фермеру нечего есть. Игра закончилась.");
    }
}
