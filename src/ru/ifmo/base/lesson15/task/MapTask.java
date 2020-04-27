package ru.ifmo.base.lesson15.task;

import ru.ifmo.base.lesson14.hw.Message;
import ru.ifmo.base.lesson15.Role;
import ru.ifmo.base.lesson15.User;

import java.util.*;

public class MapTask {
    public static List<String> getLogin(HashMap<String, String> firstTaskMap,  String city) {
        // TODO:: написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу
        List<String> logins = new ArrayList<>();
        for (Map.Entry<String,String> entry: firstTaskMap.entrySet()
        ) {
            if(city.equals(entry.getValue())) logins.add(entry.getKey());
        }
        return logins;
    }

    public static Map<String, Integer> getRepeat(List<String> words) {
        // TODO:: дан список слов (words). Написать метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений
        Map<String, Integer> mapWords = new HashMap<>();
        for (String word: words
        ) {
            if(mapWords.containsKey(word)) mapWords.replace(word, mapWords.get(word) + 1);
            else mapWords.put(word,1);
        }
        return mapWords;
    }

    public static Map<String, Customer> fromToCustomer(Map<String, Customer> customerMap, int from, int to) {
        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает новую мапу,
        //  в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)
        Map<String, Customer> newCustomerMap = new HashMap<>();
        for (Map.Entry<String,Customer> entry: customerMap.entrySet()
        ) {
            if((entry.getValue().getAge() >= from) && (entry.getValue().getAge() < to))
            newCustomerMap.put(entry.getKey(), entry.getValue());
        }
        return newCustomerMap;
    }


    public static int getCnt(List<String> stringList, String word) {
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        int cnt = 0;
        for (String entry: stringList
        ) {
            if(word.equals(entry)) cnt++;
        }
        return cnt;
    }

    public static Map<Integer, List<String>> getGrp(List<String> stringList) {
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        Map<Integer, List<String>> stringMap = new HashMap<>();
        List<String> strings = new ArrayList<>();
        int key = 0;
        for (String entry: stringList
        ) {
            char[] chr = entry.toCharArray();
            key = chr.length;
            strings = stringMap.get(key);
            if(strings != null) {strings.add(entry); stringMap.replace(key,strings);}
            else {stringMap.put(key, new ArrayList<>(Arrays.asList(entry)));}
        }
        return stringMap;
    }

    public static Map<String, Integer> topTen(List<String> stringList) {
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        Map<String, Integer> stringMap = new HashMap<>();
        Map<Integer, List<String>> topMap = new HashMap<>();
        Integer key;
        for (String entry: stringList
        ) {
            char[] chr = entry.toCharArray();
            key = stringMap.get(entry);
            if(key == null) stringMap.put(entry,1);
            else stringMap.replace(entry, ++key);
        }
        Collection<Integer> IntegerList = stringMap.values();
        Integer[] ints = new Integer[IntegerList.size()];
        IntegerList.toArray(ints);
        Arrays.sort(ints);
        for (int i = ints.length-1; i > ints.length-11; i--) {
        //    stringMap.geints[i];
            System.out.println("i["+i+"] = " + ints[i]);

        }
        return stringMap;
    }

    public static Map<Character, Double> charUse(List<Character> chars) {
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы
        Map<Character, Integer> charMap = new HashMap<>();
        Map<Character, Double> charMapDouble = new HashMap<>();
        Integer key;
        int cnt =0;
        for (Character entry: chars
        ) {
            key = charMap.get(entry);
            if(key == null) charMap.put(entry,1);
            else charMap.replace(entry, ++key);
        }
        Collection<Integer> IntegerList = charMap.values();
        Integer[] ints = new Integer[IntegerList.size()];
        IntegerList.toArray(ints);
        for (int i = 0; i < ints.length; i++) {
            cnt = cnt + ints[i];
        }
        for (Map.Entry<Character,Integer> entry: charMap.entrySet()
        ) {
            charMapDouble.put(entry.getKey(), (Double) entry.getValue().doubleValue()*100/cnt);
        }
        return charMapDouble;
    }
    // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
    //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
    //  2. написать метод, который собирает все слова в группы по количеству букв:
    //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
    //  3. написать метод, который выводит в консоль топ 10 самых частых слов
    //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

    public static void main(String[] args) {
        // TODO:: написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";
        System.out.println(getLogin(firstTaskMap,city));



        // TODO:: дан список слов (words). Написать метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");
        System.out.println(getRepeat(words));



        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает новую мапу,
        //  в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));
        System.out.println(fromToCustomer(customerMap,23,67));



        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like"; // !!! в тексте содержатся только буквы и пробельные символы !!!

        String[] strgs = text.split(" ");
        List<String> stringList = new ArrayList<>(Arrays.asList(strgs));
        System.out.println(stringList);
        System.out.println("Частота встречаемости слова в тексте" + getCnt(stringList,"it"));
        System.out.println("Группы по количеству букв:" + getGrp(stringList));
        System.out.println("Tоп 10 самых частых слов:" + topTen(stringList));

        List<Character> chars = new ArrayList<>();
        for (char ch: text.toCharArray()) {
            if (ch != ' ')chars.add(ch);
        }
        System.out.println(chars);
        System.out.println("Частота встречаемости букв:" + charUse(chars));

    }


}
