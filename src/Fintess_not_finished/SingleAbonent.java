package Fintess_not_finished;

import java.time.LocalDate;

public class SingleAbonent extends Abonent implements Single {
private int Cnt;
    public SingleAbonent(LocalDate startDate, LocalDate finishDate, Owner owner, int cnt) {
        super(startDate, finishDate, owner);
        Cnt = 0;
    }

    public void setCnt(int cnt) {
        Cnt = cnt;
    }
}
