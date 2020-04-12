package Fintess;

public class Zone {
    private int currCount;
    private final int maxCount;
    private final String TITLE;
    private Abonent[] abonents = new Abonent[20];

    public Abonent[] getAbonents() {
        return abonents;
    }

    public Zone(String TITLE) {
        this.currCount = 0;
        this.maxCount = 20;
        this.TITLE = TITLE;
    }

    public int getCurrCount() {
        return currCount;
    }

    public void plusCount(int cnt) {
        this.currCount += cnt ;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void addAbonent (Abonent a){
        if (currCount == maxCount) {System.out.println("В зоне "+getTITLE()+"зарегистрировано "+maxCount+" абонентов. Проход невозможен"); return;}
        for (int i = 0; i < abonents.length; i++) {
            if (abonents[i] == null){abonents[i] = a;plusCount(1); return;}
        }
    }
    public void clearAbonent (Abonent a){
        for (int i = 0; i < abonents.length; i++) {
            if (abonents[i] == a){abonents[i] = null; plusCount(-1); return;}
        }
    }
    public void closeAllAbonent(){
        abonents = null;
        this.currCount = 0;
    }
}
