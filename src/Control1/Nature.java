package Control1;

public class Nature {
    private final String TITLE;
    private WildAnimal[] wildAnimals = new WildAnimal[3];

    public Nature(String TITLE) {
        this.TITLE = TITLE;
    }

    public void addWildAnimal (WildAnimal wa){
        for (int i = 0; i < wildAnimals.length; i++) {
            if (wildAnimals[i] == null){wildAnimals[i] = wa; return;}
        }
    }

    public WildAnimal[] getWildAnimals() {
        return wildAnimals;
    }
}
