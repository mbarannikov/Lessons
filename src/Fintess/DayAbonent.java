package Fintess;

import java.time.LocalDate;

public class DayAbonent extends Abonent implements Day {

    public DayAbonent(LocalDate startDate, LocalDate finishDate, Owner owner) {
        super(startDate, finishDate, owner);
    }
}
