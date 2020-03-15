package lesson5;

import java.util.Arrays;

public class StringLesson {
    public static void main(String[] args) {
//        до 9 Java строки хранятся как масив char
        char charVar = 'e';
        String someStr = "jjd";
        char[] chars = {'j', 'j', 'd'}; // кодировка utf-16 символ занимает 2 байта
//       начиная с 9 Java строки хранятся как масив byte в кодировке utf-16 или latin-1
        String string = "Some string";
        String string4 = "Some string"; // пул строк общий хеш
        String string2 = new String("Some string");
        String string3 = new String("Some string"); // разные области памяти
        System.out.println(string == string4);
        System.out.println(string2 == string3);
        System.out.println(string2.equals(string3));
        String newString = new String("new");
        String newString2 = newString.intern();
        System.out.println(string2.intern() == string3.intern());

//        конкатенация строк
//        любые модификации строки приводят к созданию новой строки
        String str1 = "строка 1";
        String str2 = "строка 2";
        String str3 = "строка 3";
        str1 = str1 + str2;
//        System.out.println(str1.equals(str2));
        str2 = str2.concat(str3)
                .concat("Hello")
                .concat("STR");
        System.out.println(str2);
        str3 = String.join("::", str1, str2, str3);
        System.out.println(str3);
        str1 = "Строка ";
        for (int i = 0; i < 10; i++) {
            str1 += "итерация" + i;
        }
        System.out.println(str1);
//        для больших строк используются StringBuilder and StringBuffer
//        StringBuilder - изменение объекта непотокобезопасен
//        StringBuffer - работает медленнее потокобезопасен
//        StringBuilder sb = new StringBuilder(str1);
        String str5 = "abc";
        StringBuilder sb = new StringBuilder();
        sb.append(str5).append("Hello");
        for (int i = 0; i < 10; i++) {
            sb.append("итерация").append(i);
        }
        System.out.println(sb);
        str1 = sb.toString();
        System.out.println(str1);

        char[] charsArr = {'q', 'w', 'e'};
        String charStr = new String(charsArr);
        byte[] bytes = charStr.getBytes();
        System.out.println(charStr);
        System.out.println(Arrays.toString(bytes));
        charStr = new String(bytes);
        System.out.println(charStr);
        str1 = "Java";
        str2 = "java";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        System.out.println(str1.compareTo(str2));
        System.out.println(Arrays.toString(str1.getBytes()));
        System.out.println(Arrays.toString(str2.getBytes()));
        System.out.println(str1.startsWith("Ja"));
        System.out.println(str1.endsWith("A"));
        str1 = "      Str    ";
        System.out.println(str1.length());
        System.out.println(str1.trim().length());
        System.out.println(str2.replace("a", "bbbb"));
        str1 = "Java Junior";
        String[] strings = str1.split("\\s");
        System.out.println(Arrays.toString(strings));

        String srt1 = "string";
        String srt2 = new String("String string");
        String srt3 = "str";
        System.out.println(Arrays.toString(str1.getBytes()));
        System.out.println(Arrays.toString(str2.getBytes()));
    }
}
