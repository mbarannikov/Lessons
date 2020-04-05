package Fintess_not_finished;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Owner own1 = new Owner("Петр", "Петрович", LocalDate.of(1998, Month.OCTOBER, 20));
        Owner own2= new Owner("Иван", "Иванович", LocalDate.of(1988, Month.NOVEMBER, 20));
        Owner own3 = new Owner("Ольга", "Александровна", LocalDate.of(1989, Month.DECEMBER, 20));
        SingleAbonent sa = new SingleAbonent(LocalDate.of(2020, Month.APRIL, 20), LocalDate.of(2020, Month.APRIL, 20), own1);
        DayAbonent da = new DayAbonent(LocalDate.of(2020, Month.APRIL, 05), LocalDate.of(2021, Month.APRIL, 06), own2);
        FullAbonent fa = new FullAbonent(LocalDate.of(2020, Month.APRIL, 05), LocalDate.of(2021, Month.APRIL, 06), own3);
        Fitness club = new Fitness();
        club.open( LocalDateTime.of(2020, Month.APRIL, 06, 15, 45));
        club.addVisitor(sa,"BAS");
        club.addVisitor(da,"ZAL");
        club.addVisitor(fa,"GRP");
        Logger("BAS");
        Logger("ZAL");
        Logger("GRP");
        club.close();
    }
}
