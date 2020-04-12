package Fintess;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

//
//Реализовать возможность вывода информации о посетителях:
//сначала посетителях тренажерного зала, потом бассейна, потом групповых занятий.
//Выводить имя и фамилию посетителей в отсортированном порядке (сначала фамилия, потом имя).
//
//Реализовать возможность выводить информацию в консоль каждый раз, когда клиент посещает фитнес клуб.
//Информация для вывода:
//Фамилия
//Имя
//Вид занятия
//Дата и время посещения
//
//Методы вывода информации в консоль можно описать в отдельном классе Logger (методы можно сделать static)
public class Logger {


    public static void logVisitor(Owner o, String activity, LocalDateTime t){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        System.out.println("Клиент  "+o.toString()+"посещает клуб. Вид занятия "+activity+". Дата и время посещения "+formatter.format(t));
    }

    public static void logZone(Zone zone){
        Abonent[] abonents;
        abonents = zone.getAbonents();
        Owner[] owners = new Owner[zone.getCurrCount()];
        for (int i = 0; i < abonents.length; i++) {
            if(abonents[i]!=null){
                for (int j = 0; j < owners.length; j++) {
                    if(owners[j] == null){owners[j] = abonents[i].getOwner();break;}
                }
                }
        }
        Arrays.sort(owners);
     //   System.out.println(owners.length);
        System.out.println("Вывод информации о посетителях '"+zone.getTITLE()+"'");
        for (Owner o: owners) {
            System.out.println(o.toString());
        }
    }

    public static void logClub(Fitness club){
        logZone(club.getZAL());
        logZone(club.getBAS());
        logZone(club.getGRP());
    }


}
