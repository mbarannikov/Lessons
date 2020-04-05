package Fintess_not_finished;

//Фитнес содержит информацию об абонементах:
//    которые зарегистрированы в данный момент в тренажерном зале;
//    абонементах, которые зарегистрированы в бассейне;
//    абонементах, которые зарегистрированы на групповых занятиях.
//
//В каждой зоне (бассейн, тренажерный зал, групповые занятия) одновременно может быть зарегистрировано 20 абонентов.
//
//Когда  фитнес клуб закрывается, клиенты покидают его.
//
//Когда клиент приходит в фитнес клуб, он сообщает желаемую зону и показывает абонемент.
//Необходимо проверить может ли данный посетитель пройти в желаемую зону и пропустить его,
//если возможность существует; если посетитель не может пройти, необходимо сообщить ему причину.
//
//Посетитель не может пройти, если время абонемента не соответсвует текущему времени,
//если он пытается пройти в зону, которая не разрешена по его абонементу,
//если в зоне нет свободных мест.

import java.time.LocalDate;
import java.time.LocalTime;

public class Fitness {
    //private int currentZone; // 0 - ничего, 1 - тренажерный зал, 2 - бассейн, 3 - групповые занятия
    private LocalDate FitnessDate;
    LocalTime openTime = LocalTime.of(8, 00, 00);
    LocalTime dayTime = LocalTime.of(16, 00, 00);
    LocalTime closeTime = LocalTime.of(22, 00, 00);
    Zone BAS = new Zone("BAS");
    Zone ZAL = new Zone("ZAL");
    Zone GRP = new Zone("GRP");

    private SingleAbonent[] singleAbonents = new SingleAbonent[20]
    private DayAbonent[] dayAbonents = new DayAbonent[20];
    private FullAbonent[] fullAbonents = new FullAbonent[20];

    public LocalDate getClubDate() {
        return FitnessDate;
    }

    public void open(LocalDate FitnessDate) {

        this.FitnessDate = FitnessDate;

    }

    public void addVisitor(Abonent a, String zonePass) {

        if (a instanceof Single) {
            if (zonePass.equals("BAS")) {BAS.addAbonent(a);}
            else if (zonePass.equals("ZAL")) ZAL.addAbonent(a);
            else System.out.println(" Зона " + zonePass + " не разрешена по абонементу");
        }
        else if (a instanceof Day) {
            if (zonePass.equals("GRP")) GRP.addAbonent(a);
            else if (zonePass.equals("ZAL")) ZAL.addAbonent(a);
            else System.out.println(" Зона " + zonePass + " не разрешена по абонементу");
        }
        else if (a instanceof Full) {
            if (zonePass.equals("GRP")) GRP.addAbonent(a);
            else if (zonePass.equals("ZAL")) ZAL.addAbonent(a);
            else if (zonePass.equals("BAS")) BAS.addAbonent(a);
        }
    }

}
