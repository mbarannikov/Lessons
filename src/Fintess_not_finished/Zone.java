package Fintess_not_finished;

public class Zone {
    private int currCount;
    private final int maxCount;
    private final String TITLE;
    private Abonent[] abonents = new Abonent[20];

    public Zone(String TITLE) {
        this.currCount = 0;
        this.maxCount = 20;
        this.TITLE = TITLE;
    }

    public void addAbonent (Abonent a){
        for (int i = 0; i < abonents.length; i++) {
            if (abonents[i] == null){abonents[i] = a; abonents[i].setCurrentZone(this.TITLE); return;}
        }
    }
}
