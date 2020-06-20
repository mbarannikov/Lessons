package ru.ifmo.base.lesson22.tasks.pupils;

import ru.ifmo.base.lesson22.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {
        // ображение к enum Gender через имя класса - Pupil.Gender
        ArrayList<Pupil> pupils = new ArrayList<>();
        pupils.add(new Pupil(1,"Vasya", Pupil.Gender.MALE, LocalDate.of(1988, Month.OCTOBER, 20)));
        pupils.add(new Pupil(2,"Petya", Pupil.Gender.MALE, LocalDate.of(2008, Month.NOVEMBER, 20)));
        pupils.add(new Pupil(3,"Vasya", Pupil.Gender.MALE, LocalDate.of(1998, Month.SEPTEMBER, 20)));
        pupils.add(new Pupil(4,"Anya", Pupil.Gender.FEMALE, LocalDate.of(2009, Month.JUNE, 20)));
        pupils.add(new Pupil(5,"Katya", Pupil.Gender.FEMALE, LocalDate.of(2005, Month.FEBRUARY, 20)));

        School school = new School(pupils);

        // Используя Stream API:

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>

        System.out.println("--- Map.byGender ---");
        Map<Pupil.Gender, ArrayList<Pupil>> byGender = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender,
                        Collectors.toCollection(ArrayList::new)));
        System.out.println("Map.byGender" + byGender);
        byGender.entrySet().forEach(System.out::println);

        // 2. Найти средний возраст учеников
        System.out.println("--- Average gender ---");
        Double avgYear = pupils.stream()
                .collect(Collectors.averagingLong(pupil -> ChronoUnit.YEARS.between(pupil.getBirth(), LocalDate.now())));
        System.out.println("avgYear = " + avgYear);

        // 3. Найти самого младшего ученика

        System.out.println("--- Min pupil ---");
//        Comparator<Pupil> byAge = Comparator.comparing(Pupil::getBirth);
//        pupils.sort(byAge);
//        Collections.reverse(pupils);
//        System.out.println("Min pupil" + pupils.get(0));
        Pupil minPupil = pupils.stream()
                .max(Comparator.comparing(Pupil::getBirth))
                .orElse(new Pupil(0,"default pupil", Pupil.Gender.MALE, LocalDate.now()));
        System.out.println(minPupil);

        // 4. Найти самого старшего ученика
        System.out.println("--- Max pupil ---");
        Pupil maxPupil = pupils.stream()
                .min(Comparator.comparing(Pupil::getBirth))
                .orElse(new Pupil(0,"default pupil", Pupil.Gender.MALE, LocalDate.now()));
        System.out.println(maxPupil);
//        pupils.sort(byAge);
//        System.out.println("Max pupil" + pupils.get(0));

        // 5. Собрать учеников в группы по году рождения

        System.out.println("--- Group by birth year ---");
        Map<Integer, List<Pupil>> byBirth = pupils.stream()
                .collect(Collectors.groupingBy(p -> p.getBirth().

                        getYear()));
        byBirth.entrySet().forEach(System.out::println);

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль

        System.out.println("--- Remove with the same name ---");
        Map<String, List<Pupil>> bySameName = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getName));
        for (Map.Entry<String, List<Pupil>> entry: bySameName.entrySet()
        ) {
            if(entry.getValue().size() == 1) {
                System.out.println(entry.getValue());
            }
        }

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        System.out.println("--- Sort reverse ---");
        Comparator<Pupil> byGenderReverse = (p1, p2) -> p2.getGender().compareTo(p1.getGender());
        Comparator<Pupil> byAgeReverse = (p1, p2) -> p2.getBirth().compareTo(p1.getBirth());
        Comparator<Pupil> byNameReverse = (p1, p2) -> p2.getName().compareTo(p1.getName());
        pupils.sort(byGenderReverse.thenComparing(byAgeReverse).thenComparing(byNameReverse));
        System.out.println(pupils);

        // 8. Вывести в косоль всех учеников в возрасте от N до M лет
        System.out.println("--- age Filter from 10 to 15---");
//        Predicate<Pupil> ageFilter = pupil -> ((LocalDate.now().getYear()-pupil.getBirth().getYear()) > 10 /*&& (pupil.getBirth().getYear() < 15)*/);
//        System.out.println(school.getFilteredPupil(ageFilter));

        Pupil[] pupilsArr = pupils.stream()
                .filter(p -> (LocalDate.now().getYear() - p.getBirth().getYear() > 10))
                .filter(p -> (LocalDate.now().getYear() - p.getBirth().getYear() < 15))
                //.toArray(); Object[]
                .toArray(Pupil[]::new); // User[] u = new User[размер стрима];

        System.out.println(Arrays.toString(pupilsArr));

        // 9. Собрать в список всех учеников с именем=someName
        System.out.println("--- name Filter Anya---");
        List<Pupil> pupilList = pupils.stream()
                .filter(pupil -> pupil.getName().equalsIgnoreCase("anya"))
                .collect(Collectors.toList());
        System.out.println(pupilList);

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        System.out.println("--- Group byGenderSumAge---");
        Map<Pupil.Gender, Integer> byGenderSumAge = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender,
                        Collectors.summingInt(p -> (LocalDate.now().getYear() - p.getBirth().getYear()))));
        byGenderSumAge.entrySet().forEach(System.out::println);
    }

}

class School{
    private  List<Pupil> pupilList;

    public School(List<Pupil> pupilList) {
        this.pupilList = pupilList;
    }

    public List<Pupil> getFilteredPupil(Predicate<Pupil> filter) {
        List<Pupil> pupils = new ArrayList<>();
        for (Pupil pupil: pupilList) {
            if (filter.test(pupil)) pupils.add(pupil);
        }
        return pupils;
    }
}