package Tasks.timezone;

import java.time.LocalTime;

//Есть три рабочие смены :
//        с 7:00 до 15:00
//        с 15:00 до 23:00
//        с 23:00 до 7:00
//        Определить, какая сейчас смена (относительно текущего времени)
public class task2 {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.of(23, 59, 59);//LocalTime.now();
        LocalTime startTime1start = LocalTime.of(7, 0);
//        LocalTime startTime1end = LocalTime.of(14, 59, 59);
        LocalTime startTime2start = LocalTime.of(15, 0);
//        LocalTime startTime2end= LocalTime.of(22, 59, 59);
        LocalTime startTime3start = LocalTime.of(23, 0);
//        LocalTime startTime3end = LocalTime.of(6, 59, 59);
        if (currentTime.isBefore(startTime1start)) {
            System.out.println("Третья смена");
        } else if(currentTime.isBefore(startTime2start)) {
            System.out.println("Первая смена");
        } else if(currentTime.isBefore(startTime3start)) {
            System.out.println("Вторая смена");
        } else
            System.out.println("Третья смена");
    }
}
