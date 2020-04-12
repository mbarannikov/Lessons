package Fintess;

import java.time.LocalDate;

public class FullAbonent extends Abonent implements Full {
    public FullAbonent(LocalDate startDate, LocalDate finishDate, Owner owner) {
        super(startDate, finishDate, owner);
    }
}
