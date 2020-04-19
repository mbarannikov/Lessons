package Tasks.timezone;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

//Допустим,  занятия закончатся 20 июня 2020 года.
//        Сколько занятий осталось, если они проходят 3 раза в неделю (пн, ср, пт)?
public class task3 {
    public static void main(String[] args) {
        long weeks;
        int day;
        int zan=0;
        LocalDate currentDate = LocalDate.of(2020, Month.APRIL, 12);
        LocalDate futureDate = LocalDate.of(2020, Month.APRIL, 25);
        weeks = ChronoUnit.WEEKS.between(currentDate, futureDate);
        day = currentDate.getDayOfWeek().getValue();
        System.out.println(day);
        System.out.println(futureDate.getDayOfWeek().getValue()); // 6
        if(day == 1||day == 7){
            zan = 3;
        }else if(day == 2||day == 3){
            zan = 2;
        }else if(day == 4||day == 5){
            zan = 1;
        }
        zan += weeks*3;
        System.out.println("Количество занятий = "+zan);
    }
}