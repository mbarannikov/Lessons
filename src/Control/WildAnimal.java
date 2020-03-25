package Control;

//Дикие животные:
//        Волк, Медведь, Лисица.
//        обладают следующими характеристиками:
//        имя, вес, скорость, сила
//        Дикое животное может съесть (либо ранить) домашнее животное, если оно не убежит.
//        Если домашнее животное было съедено, то оно не остается на ферме (из массива удалять не обязательно, можно использовать какой нибудь флаг, onFarm:true/false)!
//        Если фермер прогнал дикое животное с фермы 3 раза, то в 4й раз оно не может прийти на ферму.

public class WildAnimal extends Animal implements CanAttack{
    int strength;
    int farmAttackCount;

    @Override
    public void attack(FarmAnimal fa) {
        if (this.farmAttackCount<4&&fa.speed < this.speed){
            fa.health-=this.strength;
            if (fa.health<0){fa.setOnFarm(false);}
        }
    }

    public void setFarmAttackCount(int farmAttackCount) {
        this.farmAttackCount = farmAttackCount;
    }

    public WildAnimal(String name, int weight, int speed, int strength) {
        super(name, weight, speed);
        this.strength = strength;
        this.farmAttackCount = 0;
    }

}
