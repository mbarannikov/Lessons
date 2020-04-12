package ru.ifmo.base.testlesson;

public class PrimitiveWrapper {
    public static void main(String[] args) {
//  class      Byte, Short, Integer, Long, Float, Double, Character, Boolean
//         всегда нужно использовать примитивы, за исключением
//         1. когда использование примитивов не возможно и
//        2. когда необходимо воспользоваться методами классов - оберток
        int count = 267;
//        Integer age = new Integer(200);
        Integer age = 200;
//        автоупаковка и автораспаковка
        Integer num = 12;
        double price;
        Double someDouble = 45.12;
        price = someDouble;
        byte one = 1;
        num = (int) one;
        Byte two = 2;
        int num2 = num;
        PrimitiveWrapper.int2(3);
// автоупаковка и распаковка не работает с массивами
        double[] doubles = {2.16, 3.14, -9.99};
//        double2Console(doubles);
        num.intValue(); // вернет примитив
//        parse возращает примитив, valueOf объект
        System.out.println(Byte.parseByte("2")); // byte
        System.out.println(Byte.valueOf("2")); // Byte
        System.out.println(Integer.parseInt("34"));
        System.out.println(Integer.valueOf("34"));
        System.out.println(num.hashCode());
        System.out.println(Long.TYPE);
        Long first = 55L;
        Long second = 55L;
        System.out.println(Long.compare(first,second));
        System.out.println(first==second);
        Integer someInt = 12;
        Integer someInt2 = 12;
        System.out.println(someInt.compareTo(someInt2));
        System.out.println(Integer.compare(someInt,someInt2));
        System.out.println(second.equals(first));
        System.out.println(Integer.BYTES);
    }

    private static void int2 (Integer someInt){
        System.out.println("Квадрат значения="+someInt*someInt);
    }
    private static void double2Console (Double[] doubles){
        for (Double d: doubles) {
            System.out.println(" "+d);
        }
    }
}
