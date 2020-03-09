package lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class FirstLesson {
//    psvm

    public static void main(String[] args) {
/*
        1.Примитивные типы
        byte  - 1 byte -128 +127
        short - 2 byte -32768 +32767
        int   - 4 byte
        long  - 8 byte
        float - 4 byte
        double - 4 byte
        char  - 2 byte - 0-65536 unicode symbole utf - 16
        boolean - true/false
*/
byte byteVar;
byte byteVar1, byteVar2;
byte byteVar3 = 35;
byte byteVar4 = 20, byteVar5 =30;
short shortVar1 = 300;
short shortVar2 = 200;
//int shortVar3 = shortVar1 + shortVar2 + byteVar;
int intVar = 2_000_000;
//int zeroDivision = intVar/0;
long longVar = 3000000000l;
byteVar = 10;
byteVar = 12;
float floatVar = 5.7f;
float floatVar2 = floatVar/0;
double doubleVar = -3.7;
double doubleVar2 = doubleVar/0;
boolean isActive = true;
boolean isClosed = false;
// sout
        System.out.println("floatVar2= "+floatVar2);
        System.out.println(doubleVar2);

//  TODO: почему не стоит полагаться на точность float and double
//
//   1. автоматичесоке приведение типов
        byte someByte = 10;
        int someInt = someByte;
//    2. явное приведение типов
   someByte = (byte)someInt;
//   операторы присваивания
//        =|+=|-=|*=|/=|%=
        int a = 10;
        a += 7; // a=a+7;
//        арифметические операции
        a =12;
        int b = 7;
        int c = a/b;
        double c1 = (double)a/b;
        System.out.println(c);
        System.out.println(c1);
//        операторы сравнения, результат true или false
//        |>=|<=|!=|==
// postfix and prefix increment and decrement
//        ++|--
//        i++; ++i; i--; --i;
//        консольный вывод
        System.out.printf("Форматированный вывод %s \n","данных");
//        консольный ввод
   /*     Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int num = in.nextInt();
        System.out.printf("Вы ввели %d\n",num);*/
        // логические операторы работают с типом boolean
//        &&/||/!/^
//        тернарный оператор
//        переменная  = (условие)?выражение 1: выражение 2;
        a=23; b=3;
        c  = a%2==0?a/2:a*2;
        System.out.println(c);
        a=2;
        int aRes = a++ - ++a + a++ +a++ +a;
//        2-4+4+5+6
        System.out.println(aRes);
    }
}
