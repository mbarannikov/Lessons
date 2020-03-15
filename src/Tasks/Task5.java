package Tasks;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
//        1. Даны 2 слова, состоящие из четного числа букв.
//        Получить слово состоящее из первой половины первого слова и второй половины второго слова.
        String srt1 = "first_";
        String srt2 = "second";
        String srt3 = srt1.substring(0, srt1.length() / 2) + srt2.substring(srt2.length() / 2);
        System.out.println(srt3);
//        2. Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины.
        String srt4 = "first second thee";
        String[] strings = srt4.split("\\s");
        int maxLength;
        maxLength = 0;
        for (int i = 0; i < strings.length; i++) {
//            System.out.println(Arrays.toString(strings));
            if (maxLength < strings[i].length()) {
                maxLength = strings[i].length();
            }
        }
        System.out.println(maxLength);
//        3. Имеются две строки. Найти количество вхождений одной строки в другую.
        srt1 = "aa first aa bb dd aaaa";
        srt2 = "aa";
        //   System.out.println(srt1.contains(srt2));
        strings = srt1.split("\\s");
        int iCnt = 0;
        for (int i = 0; i < strings.length; i++) {
//            System.out.println(Arrays.toString(strings));
            if (strings[i].contains(srt2)) {
                iCnt++;
            }
        }
        System.out.println(iCnt);
//        4. Написать функцию, которая проверяет, является ли строка палиндромом. Палиндром — это слово или фраза, которые одинаково читаются по буквам или по словам как слева направо, так и справа налево.
        srt1 = "abccba";
        srt2 = "Палидром";
        byte[] bytes = srt1.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != bytes[bytes.length - 1 - i]) {
                srt2 = "не Палидром";
                break;
            }
        }
        System.out.println(srt2);

//        5. Даны два слова и словарь (массив слов). Необходимо найти алгоритм превращения в другое, меняя за один шаг одну букву, причем каждое новое слово должно быть в словаре (массиве слов).
//                Например,даны слова "hit" и "cog" и словарь(массив слов) ["hot", "dot", "dog", "log", "lot"].
//        Один из вариантов цепочки: "hit"->"hot"->"dot"->"dog"->"cog".

//        6. Пользователь вводит названия городов через пробел. Вы их присваиваете переменной. Переставьте названия так, чтобы они были упорядочены по алфавиту.
//
        srt1 = "Питер Москва Казань";
        strings = srt1.split("\\s");
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

    }
}
