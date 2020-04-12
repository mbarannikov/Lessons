package Fintess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Owner own1 = new Owner("Один", "Одиночный", LocalDate.of(1998, Month.OCTOBER, 20));
        Owner own2= new Owner("Два", "Дневной", LocalDate.of(1988, Month.NOVEMBER, 20));
        Owner own3 = new Owner("Три", "Полный", LocalDate.of(1989, Month.DECEMBER, 20));
        Owner own4 = new Owner("Четыре", "Одиночный", LocalDate.of(1998, Month.OCTOBER, 20));
        Owner own5= new Owner("Пять", "Дневной", LocalDate.of(1988, Month.NOVEMBER, 20));
        Owner own6 = new Owner("Шесть", "Полный", LocalDate.of(1989, Month.DECEMBER, 20));
        Owner own7 = new Owner("Семь", "Одиночный", LocalDate.of(1998, Month.OCTOBER, 20));
        Owner own8= new Owner("Восемь", "Дневной", LocalDate.of(1988, Month.NOVEMBER, 20));
        Owner own9 = new Owner("Девять", "Полный", LocalDate.of(1989, Month.DECEMBER, 20));
        SingleAbonent sa1 = new SingleAbonent(LocalDate.of(1900, Month.JANUARY, 1), LocalDate.of(2100, Month.DECEMBER, 31), own1);
        DayAbonent da1 = new DayAbonent(LocalDate.of(2020, Month.APRIL, 05), LocalDate.of(2023, Month.APRIL, 06), own2);
        FullAbonent fa1 = new FullAbonent(LocalDate.of(2020, Month.APRIL, 05), LocalDate.of(2023, Month.APRIL, 06), own3);
        SingleAbonent sa2 = new SingleAbonent(LocalDate.of(1900, Month.JANUARY, 1), LocalDate.of(2100, Month.DECEMBER, 31), own4);
        DayAbonent da2 = new DayAbonent(LocalDate.of(2021, Month.APRIL, 05), LocalDate.of(2024, Month.APRIL, 06), own5);
        FullAbonent fa2 = new FullAbonent(LocalDate.of(2021, Month.APRIL, 05), LocalDate.of(2024, Month.APRIL, 06), own6);
        SingleAbonent sa3 = new SingleAbonent(LocalDate.of(1900, Month.JANUARY, 1), LocalDate.of(2100, Month.DECEMBER, 31), own7);
        DayAbonent da3 = new DayAbonent(LocalDate.of(2022, Month.APRIL, 05), LocalDate.of(2025, Month.APRIL, 06), own8);
        FullAbonent fa3 = new FullAbonent(LocalDate.of(2022, Month.APRIL, 05), LocalDate.of(2025, Month.APRIL, 06), own9);
        Fitness club = new Fitness();
        club.open( LocalDateTime.of(2020, Month.APRIL, 10, 10, 45));
        club.logOnVisitor(sa1,"BAS");
        club.logOnVisitor(da1,"BAS");
        club.logOnVisitor(fa1,"BAS");
        club.logOnVisitor(sa2,"ZAL");
        club.logOnVisitor(da2,"ZAL");
        club.logOnVisitor(fa2,"ZAL");
        club.logOnVisitor(sa3,"GRP");
        club.logOnVisitor(da3,"GRP");
        club.logOnVisitor(fa3,"GRP");
//        club.logOffVisitor(sa1);
//        club.logOffVisitor(sa2);
//        club.logOffVisitor(sa3);
//        club.logOnVisitor(sa1,"GRP");
//        club.logOnVisitor(sa3,"GRP");
//        club.logOnVisitor(sa3,"GRP");
        Logger.logClub(club);
        club.logOffVisitor(sa1);
        club.logOffVisitor(da1);
        club.logOffVisitor(fa1);
        club.logOffVisitor(sa2);
        club.logOffVisitor(da2);
        club.logOffVisitor(fa2);
        club.logOffVisitor(sa3);
        club.logOffVisitor(da3);
        club.logOffVisitor(fa3);
        club.close();
    }
}
