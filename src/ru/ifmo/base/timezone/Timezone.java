package ru.ifmo.base.timezone;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Timezone {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        // Работа с временными зонами - класс ZonedDateTime (основные методы):
        // ZonedDateTime просто содержит внутри себя LocalDateTime и ZoneId
//        ZoneId - является представлением часового пояса , например Europe/Moscow

        // Все часовые пояса
        // List<String> zones = new ArrayList<>(ZoneId.getAvailableZoneIds());
        //zones.forEach(System.out::println);

        // Самолет вылетает из Сиднея (дата любая, например 16 июня 2020) в 19:00 (время местное для Сиднея).
        LocalDateTime someDateTime = LocalDateTime.of(2020, Month.JUNE, 16, 19, 00);
        ZonedDateTime flightDateTime;
        ZonedDateTime sydneyDateTime = someDateTime.atZone(ZoneId.of("Australia/Sydney"));
        flightDateTime = sydneyDateTime.plusHours(15).plusMinutes(35);
        ZonedDateTime houstonDateTime = flightDateTime.withZoneSameInstant(ZoneId.of("America/Chicago"));
        flightDateTime = houstonDateTime.plusHours(1).plusHours(2).plusMinutes(49);
        System.out.println("Время вылета! из аэропорта Хьюстона (время местное для Хьюстона) " + houstonDateTime.plusHours(1).format(formatter));
        ZonedDateTime washingtonDateTime = flightDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        flightDateTime = washingtonDateTime.plusHours(1).plusMinutes(10).plusHours(1).plusMinutes(40);
        System.out.println("Время вылета! из аэропорта Вашингтона (время местное для Вашингтона) " + washingtonDateTime.plusHours(1).plusMinutes(10).format(formatter));
        ZonedDateTime ottawaDateTime = flightDateTime.withZoneSameInstant(ZoneId.of("America/Toronto"));
        System.out.println("Время прибытия! в аэропорт Оттавы (время местное для Оттавы) " + ottawaDateTime.format(formatter));
        // TODO: задача на работу с датой и временем
        /*Самолет летит из Сиднея в Оттаву с двумя остановками в Хьюстоне и Вашингтоне.
        Самолет вылетает из Сиднея (дата любая, например 16 июня 2020) в 19:00 (время местное для Сиднея).

        Время в пути Сидней -  Хьюстон - 15 часов 35 минут
        Время ожидания в аэропорту Хьюстона - 1 час
        Время в пути  Хьюстон - Вашингтон - 2 часа 49 минут
        Время ожидания в аэропорту Вашингтона - 1 час 10 минут
        Время в пути Вашингтон - Оттава - 1 час 40 минут

        Вывести в консоль:
        Время прибытия! в аэропорт Оттавы (время местное для Оттавы)
        Время вылета! из аэропорта Хьюстона (время местное для Хьюстона)
        Время вылета! из аэропорта Вашингтона (время местное для Вашингтона)

        Часовые пояса:
        Сидней - Australia/Sydney
        Хьюстон - America/Chicago
        Вашингтон - America/New_York
        Оттава - America/Toronto*/
    }
}
