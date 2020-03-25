package Control;

public class Farm {
    Farmer farmer;
    FarmAnimal[] farmAnimals = new FarmAnimal[10];

    public void dayOnFarm(){
        farmer.res -=2;
        farmer.takeRes(farmAnimals);
        farmer.takeMeat(farmAnimals);
    }
    wildAnimal.eat(FarmAnimal[10]);
}
