package Fintess;

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
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Fitness {
    //private int currentZone; // 0 - ничего, 1 - тренажерный зал, 2 - бассейн, 3 - групповые занятия
    LocalDateTime FitnessDateTime;
    LocalTime openTime = LocalTime.of(8, 00, 00);
    LocalTime dayTime = LocalTime.of(16, 00, 00);
    LocalTime closeTime = LocalTime.of(22, 00, 00);
    Zone BAS = new Zone("Бассейн");
    Zone ZAL = new Zone("Тренажерный зал");
    Zone GRP = new Zone("Групповые занятия");

    public Zone getBAS() {
        return BAS;
    }

    public Zone getZAL() {
        return ZAL;
    }

    public Zone getGRP() {
        return GRP;
    }

    private SingleAbonent[] singleAbonents = new SingleAbonent[100];
//    private DayAbonent[] dayAbonents = new DayAbonent[100];
//    private FullAbonent[] fullAbonents = new FullAbonent[100];

    public LocalDateTime getClubDate() {
        return FitnessDateTime;
    }

    public void open(LocalDateTime FitnessDateTime) {
        this.FitnessDateTime = FitnessDateTime;
    }

//    public void addVisitor(Abonent a) {
//        if (a instanceof Single) {
//            for (int i = 0; i < singleAbonents.length; i++) {
//                if (singleAbonents[i] == null){singleAbonents[i] = (SingleAbonent) a; return;}
//            }
//        }
//        else if (a instanceof Day) {
//            for (int i = 0; i < dayAbonents.length; i++) {
//                if (dayAbonents[i] == null){dayAbonents[i] = (DayAbonent) a; return;}
//            }
//        }
//        else if (a instanceof Full) {
//            for (int i = 0; i < fullAbonents.length; i++) {
//                if (fullAbonents[i] == null){fullAbonents[i] = (FullAbonent) a; return;}
//            }
//        }
//    }

    public void close() {
        BAS.closeAllAbonent();
        ZAL.closeAllAbonent();
        GRP.closeAllAbonent();
        singleAbonents = null;
    }

    public boolean checkDay(Abonent a) {
        LocalTime retrievedTime;
        LocalDate retrievedDate;
        boolean isAfterT = true;
        boolean isBeforeT = true;
        boolean isAfterD = true;
        boolean isBeforeD = true;
        if (a instanceof Single) {
            retrievedTime = getClubDate().toLocalTime();
            isAfterT = retrievedTime.isAfter(openTime);
            isBeforeT = retrievedTime.isBefore(closeTime);
        } else if (a instanceof Day) {
            retrievedDate = getClubDate().toLocalDate();
            isAfterD = retrievedDate.isAfter(a.getStartDate());
            isBeforeD = retrievedDate.isBefore(a.getFinishDate());
            if (isAfterD && isBeforeD) {
                retrievedTime = getClubDate().toLocalTime();
                isAfterT = retrievedTime.isAfter(openTime);
                isBeforeT = retrievedTime.isBefore(dayTime);
            }

        } else if (a instanceof Full) {
            retrievedDate = getClubDate().toLocalDate();
            isAfterD = retrievedDate.isAfter(a.getStartDate());
            isBeforeD = retrievedDate.isBefore(a.getFinishDate());
            if (isAfterD && isBeforeD) {
                retrievedTime = getClubDate().toLocalTime();
                isAfterT = retrievedTime.isAfter(openTime);
                isBeforeT = retrievedTime.isBefore(closeTime);
            }

        }
        if (!(isAfterD && isBeforeD) ){System.out.println("Срок Регистрации Абонемента "+a.getOwner().toString()+" не наступил или завершен"); return false;}
        else if (!(isAfterT && isBeforeT) ){System.out.println("Время входа в клуб "+a.getOwner().toString()+" не наступило или завершено"); return false;}
        else if (isAfterT&&isBeforeT) return true;
        else {System.out.println("Что то не так со временем"); return false;}
    }


    public void logOnVisitor(Abonent a, String zonePass) {
        boolean isPass = false;
        String activity = null;
        if (a instanceof Single) {
            for (int i = 0; i < singleAbonents.length; i++) {
                if (singleAbonents[i] == a){System.out.println("Посещение "+a.getOwner().toString()+" заблокировано"); return;}
            }
        }
        if (a instanceof Single&&checkDay(a)) {
            if (zonePass.equals("BAS")) {BAS.addAbonent(a); activity = BAS.getTITLE(); isPass =true;}
            else if (zonePass.equals("ZAL")) {ZAL.addAbonent(a);activity = ZAL.getTITLE();isPass =true;}
            else System.out.println("Зона " +  GRP.getTITLE() + " не разрешена по абонементу "+a.getOwner().toString());
        }
        else if (a instanceof Day&&checkDay(a)) {
            if (zonePass.equals("GRP")) {GRP.addAbonent(a);activity = GRP.getTITLE();isPass =true;}
            else if (zonePass.equals("ZAL")) {ZAL.addAbonent(a); activity = ZAL.getTITLE();isPass =true;}
            else System.out.println("Зона '" +  BAS.getTITLE() + "' не разрешена по абонементу "+a.getOwner().toString());
        }
        else if (a instanceof Full&&checkDay(a)) {
            if (zonePass.equals("GRP")) {GRP.addAbonent(a); activity = GRP.getTITLE();isPass =true;}
            else if (zonePass.equals("ZAL")) {ZAL.addAbonent(a); activity = ZAL.getTITLE();isPass =true;}
            else if (zonePass.equals("BAS")) {BAS.addAbonent(a); activity = BAS.getTITLE();isPass =true;}
        }
        if(isPass){
            a.setCurrentZone(zonePass);
            Logger.logVisitor(a.getOwner(),activity,getClubDate());
        }

    }

    public void logOffVisitor(Abonent a) {
        System.out.println("Aбонемент "+a.getOwner().toString()+" покинул клуб");
        String zone = a.getCurrentZone();
        if (zone == null) return;
        if (a instanceof Single) {
            for (int i = 0; i < singleAbonents.length; i++) {
                if (singleAbonents[i] == null){singleAbonents[i] = (SingleAbonent) a; }
            }
        }
        if (zone.equals("BAS")) BAS.clearAbonent(a);
        else if (zone.equals("ZAL")) ZAL.clearAbonent(a);
        else if (zone.equals("GRP")) GRP.clearAbonent(a);
        a.setCurrentZone(null);
    }

}
