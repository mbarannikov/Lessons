package Control1;

//Дикие животные:
//        Волк, Медведь, Лисица.
//        обладают следующими характеристиками:
//        имя, вес, скорость, сила
//        Дикое животное может съесть (либо ранить) домашнее животное, если оно не убежит.
//        Если домашнее животное было съедено, то оно не остается на ферме (из массива удалять не обязательно, можно использовать какой нибудь флаг, onFarm:true/false)!
//        Если фермер прогнал дикое животное с фермы 3 раза, то в 4й раз оно не может прийти на ферму.

public class WildAnimal extends Animal implements CanAttack{
    private int strength;
    private int farmAttackCount;

    public WildAnimal(String name, int weight, int speed, int strength) {
        super(name, weight, speed);
        this.strength = strength;
        this.farmAttackCount = 0;
    }
    public void setFarmAttackCount(int farmAttackCount) {
        this.farmAttackCount = farmAttackCount;
    }

    public int getFarmAttackCount() {
        return farmAttackCount;
    }

    public void kicked(){
        if(farmAttackCount<3){
            farmAttackCount++;
            System.out.println("Фермер прогнал "+getName()+" число попыток "+farmAttackCount);
        }
    }

    @Override
    public void attack(FarmAnimal fa) {
        if (farmAttackCount<4&&fa.getSpeed() < getSpeed()&&fa.isOnFarm()){
            fa.attacked(strength);
            System.out.println("Хищник "+getName()+" атаковал "+fa.getName());
        }else System.out.println("Хищник "+getName()+" не смог атаковать. Попыток "+farmAttackCount+"Скорость хищника "+getSpeed()+"Скорость домашнего животного "+fa.getSpeed());
    }


    public void attackFarm(FarmAnimal[] animals, int randAttack) {
        if (animals[randAttack].isOnFarm()) attack(animals[randAttack]);
        else {
            for (int i = 0; i < animals.length; i++) {
                if (i == randAttack) continue;
                if (animals[i].isOnFarm()) {
                    attack(animals[i]);
                    return;
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() +"WildAnimal{" +
                "strength=" + strength +
                ", farmAttackCount=" + farmAttackCount +
                '}';
    }
}
