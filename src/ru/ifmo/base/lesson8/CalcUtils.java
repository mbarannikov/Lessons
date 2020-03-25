package ru.ifmo.base.lesson8;

public class CalcUtils {
//    оператор final с классом запрещает наследоваться от этого класса
    final double PI_VAR;
    // константа, значение нельзя изменить, объявлеы сразу или в конструкторе
//    пишуться в верхнем регистре
    static final double PI; //
    static { // загружается в память один раз, когда загружается класс
        PI = 3.14;
    }
public static int summ(int a, int b){  //обслуживающие или вспомогательные методы
    //    someVoid();   из статических методов не можем обращаться к нестатическим свойствам и методам
        return a+b;
}
    public CalcUtils() {
        PI_VAR = 3.14;
    }
// final методы нельзя переопределить в дочерних классах
// final аргументы в методе доступны только для чтения
    public final void someVoid(final int num, final SomeClass sc, final int[] arr){
        System.out.println(num);
//        num = 90;
        System.out.println(sc);
        System.out.println(sc.name);
        sc.name = "Новое имя";
//        sc = new SomeClass(); не можем записать другое ссылку
        arr[4] = 34;
    }
}

//class Child extends CalcUtils{
//    @Override
//    public void someVoid() {
//        super.someVoid();
//    }
//}

class SomeClass {
    String  name;

}
