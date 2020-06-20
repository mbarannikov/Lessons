package ru.ifmo.base.lesson22.tasks;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class TopTenWords {
    public static void main(String[] args) throws IOException {
        // создать Map<String, Long> map
        // String - слово
        // Long - частота встречаемости
        // в мапу должны войти только первые 10 частоте встречаемости слов


        // текст в файле
        File file = new File("sources/task21.txt");
//        List<String> lines = Files.lines(file.toPath()).collect(Collectors.toList());
//        System.out.println(lines);
        // = читаем из файла в stream
        Map<String, Long> map = Files.lines(file.toPath())
      //  List<String> lines = Files.lines(file.toPath())
                // сделать stream параллельным
                .parallel()
                // обработать каждый элемент: убрать пробелы, привести к нижнему регистру
                .map(String::toLowerCase)
                //.map(String::replaceAll("\n",""))
                .filter(s -> !s.isEmpty())
               //text = text.replace("\n", "").replace("\r", "");
                // создать новый stream: массив слов - flatMap
                //.flatMap(str -> Stream.of(str.split("\\P{L}")))
                .flatMap(str -> Stream.of(str.split("\\s+")))
                // собрать в map: слово - количество
                .collect(groupingBy(Function.identity(), counting()))
                // получить entrySet() терминальная операция!!!
                .entrySet()
                //.stream()
                // снова создать параллельный stream
                .parallelStream()
                // сортировать по значениям
                //.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                // получить первые 10 элементов
                .limit(2)
                // собирать мапу; терминальная операция!!!
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
//                .collect(Collectors.toMap(
//                        Function.identity(), // ключи elem->elem
//                        String::length, // значения elem->elem.length()
//                        (item1, item2) -> item1
//                ));
//{=2, еще=4, ЛИНИЯ=1, бывает=2, одна=4, не=2, и=2, линий=2, мало=2, линия=5}
        // вывести в консоль
        System.out.println(map);
        map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .forEach(System.out::println);
        TreeMap<String, Long> treeMap = new TreeMap<>(map);
        System.out.println(treeMap);
    }
}
