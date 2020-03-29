package Control1;

public class Main {
    public static void main(String[] args) {
        Cow cow = new Cow("Буренка",
                (int)(Math.random()*5+5) , // weight
                (int)(Math.random()*1+1),  //speed
                (int)(Math.random()*5+5),  //health
                (int)(Math.random()*5+5)); // res
        Rabbit rabbit = new Rabbit("Роджер",(int)(Math.random()*1+1), (int)(Math.random()*4+4), (int)(Math.random()*5+5), 0);
        Cat cat = new Cat("Мурзик",(int)(Math.random()*2+2), (int)(Math.random()*3+3), (int)(Math.random()*5+5), 0);
        Chicken chicken = new Chicken("Кукареку",(int)(Math.random()*2+2), (int)(Math.random()*4+4), (int)(Math.random()*5+5), (int)(Math.random()*3+3));
        Wolf wolf = new Wolf("Серый",(int)(Math.random()*3+3),(int)(Math.random()*5+5), (int)(Math.random()*4+4) );
        Fox fox = new Fox("Рыжая",(int)(Math.random()*2+2),(int)(Math.random()*5+5), (int)(Math.random()*3+3) );
        Bear bear = new Bear("Косолапый",(int)(Math.random()*5+5),(int)(Math.random()*3+3), (int)(Math.random()*5+5) );
        Farmer farmer = new Farmer("Петрович");
        Farm farm = new Farm("Моя ферма",farmer);
        Nature nature = new Nature("Лес");

        farm.addFarmAnimal(cow);
        farm.addFarmAnimal(rabbit);
        farm.addFarmAnimal(cat);
        farm.addFarmAnimal(chicken);
        nature.addWildAnimal(wolf);
        nature.addWildAnimal(fox);
        nature.addWildAnimal(bear);
        farm.dayOnFarm(nature);
    }
}
