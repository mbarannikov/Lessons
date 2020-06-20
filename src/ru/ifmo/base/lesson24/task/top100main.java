package ru.ifmo.base.lesson24.task;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class top100main {

    public static void main(String[] args) throws IOException {
        // создать Map<String, Long> map
        // String - слово
        // Long - частота встречаемости
        // в мапу должны войти только первые 10 частоте встречаемости слов


        // текст в файле
        File file = new File("sources/task24.txt");
        List<String> list = Files.lines(file.toPath()).collect(Collectors.toList());
        int group = Runtime.getRuntime().availableProcessors();
        int slice = list.size() / group;
        int last = list.size() % group + slice;
        Map<String, Long> mainMap = new HashMap<>();
        ArrayList<Thread> threads = new ArrayList<>();
        int i = 0;
        for (; i < list.size() - last; i=i+slice) {
            threads.add(new Thread(new GetMap(mainMap, list.subList(i, i+slice))));
            System.out.println(i);
        }
        threads.add(new Thread(new GetMap(mainMap, list.subList(i, list.size()))));


//        while (i < list.size()) {
//            i += slice;
//            threads.add(new Thread(new GetMap(mainMap, list.subList(first, i))));
//        }
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


//        System.out.println("slice = " + slice);
//        System.out.println("first = " + first);
//        List<String> list1 = list.subList(0, 7);
//        List<String> list2 = list.subList(7, 14);
//        System.out.println("list1 = " + list1);
//        System.out.println("list2 = " + list2);
////        Stream<String> linesOne =  Stream.empty();
////        linesOne = getSlice(lines,0,7);
////        Stream<String> linesTwo =  getSlice(lines,7,14);
//
//        Thread threadOne = new Thread(new GetMap(mainMap, list1));
//        Thread threadTwo = new Thread(new GetMap(mainMap, list2));
//        threadOne.start();
//        threadTwo.start();
//        try {
//            threadOne.join();
//            threadTwo.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(mainMap);
        mainMap.entrySet()
                .stream()
                .sorted((c1, c2) -> c2.getValue()
                        .compareTo(c1.getValue()))
                .limit(100)
                .forEach(System.out::println);
    }

}

class GetMap implements Runnable {

    private Map<String, Long> mainMap;
    private List<String> list;

    public GetMap(Map<String, Long> map, List<String> list) {
        this.mainMap = map;
        this.list = list;
    }

    @Override
    public void run() {
        Map<String, Long> subMap = list.stream()
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
                // собирать мапу; терминальная операция!!!
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        synchronized (mainMap) {
            for (Map.Entry<String, Long> entry : subMap.entrySet()
            ) {
                String key = entry.getKey();
                Long value = entry.getValue();
                if (mainMap.containsKey(key)) {
                    mainMap.replace(key, value + mainMap.get(key));
                } else mainMap.put(key, value);
            }
            System.out.println("Thread = " + Thread.currentThread().getName()
                    + " subMap = " + subMap
                    + " mainMap = " + mainMap);

        }
    }
}
