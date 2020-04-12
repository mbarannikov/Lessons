package Fintess;

import java.time.LocalDate;

public class SingleAbonent extends Abonent implements Single {
    public SingleAbonent(LocalDate startDate, LocalDate finishDate, Owner owner) {
        super(startDate, finishDate, owner);
    }
}
