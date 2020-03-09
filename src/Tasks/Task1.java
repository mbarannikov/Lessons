package Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
//      1.  Найти наибольший общий делитель (НОД) двух чисел
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число");
        int num1 = in.nextInt();
        System.out.println("Введите второе число");
        int num2 = in.nextInt();
        int nod =1, minNum;
        minNum = (num1>num2) ? num2 : num1;
        for (int i = 1; i <= minNum; i++) {
            if (num1%i==0 && num2%i==0){
                nod = i;
            }
        }
        System.out.println("Nod = "+nod);
/*2. Дан массив целых чисел.
//   Массив не отсортирован, числа могут повторяться.
//   Необходимо найти в данном массиве такие два числа n и m, чтобы их сумма была равна 7.
//   Например, 2 + 5 = 7, 6 + 1 = 7, -2 + 9 = 7. Постарайтесь решить задачу наиболее оптимальным способом*/
        int [] someArr7;
        someArr7 = new int[]{23,1,4,-10,3,51,7,2,5,6};
        Arrays.sort(someArr7);
        System.out.println(Arrays.toString(someArr7));
        int maxIndex = Arrays.binarySearch(someArr7, 7);

        for (int i = 0; i < maxIndex; i++) {
            for (int j = i+1; j < maxIndex; j++) {
                if (someArr7[i] + someArr7[j] == 7) {
                    System.out.println(someArr7[i]+"+"+someArr7[j]);
                }
            }
        }
//        3. Заполните массив на N элементов случайным числами и выведете максимальное, минимальное и среднее значение.
        int sizeN = 4, maxVal = 0, minVal = 0;
        float midVal = 0;
        someArr7 = new int [sizeN];
        for (int i = 0; i < someArr7.length; i++) {
          someArr7[i] =   (int) (Math.random() * sizeN);
          midVal += someArr7[i];
          if (someArr7[i] > maxVal) {maxVal = someArr7[i];}
          else if (someArr7[i] < minVal){minVal = someArr7[i];}
        }
        midVal = midVal/sizeN;
        System.out.println(Arrays.toString(someArr7));
        System.out.println("min="+minVal+" max="+maxVal+" mid="+midVal);
//        4. Пользователь вводит с клавиатуры натуральное число большее 3, которое сохраняется в переменную n.
//        Если пользователь ввёл не подходящее число, то программа должна просить пользователя повторить ввод.
//        Создать массив из n случайных целых чисел из отрезка [0;n] и вывести его на экран.
//        Создать второй массив только из чётных элементов первого массива, если они там есть, и вывести его в консоль
        in = new Scanner(System.in);
        System.out.println("натуральное число большее 3");

        num1 = in.nextInt();
        while (num1 <=3) {
            System.out.println("Повторите ввод");
            num1 = in.nextInt();
        }
        int [] someArr4 = new int [num1];
        int [] someArrN = new int[num1];

        int j = 0;
        for (int i = 0; i < someArr4.length; i++) {
            someArr4[i] = (int) (Math.random() * num1 + 1);
            if (someArr4[i]%2==0) {someArrN[j]=someArr4[i]; j++;};
        }
        int [] someArrCopy = new int[j];
        for (int i = 0; i < j; i++) {someArrCopy[i] = someArrN[i];};

        System.out.println(Arrays.toString(someArr4));
        System.out.println(Arrays.toString(someArrCopy));

//        5. Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых чисел из отрезка [-99;99].
//        Вывести массив в консоль.
//        После на отдельной строке вывести в консоль значение максимального элемента этого массива.
                int [][] someArr5 = new int[5][8];
                maxVal =0;
                int randVal1 = 0;
                int randVal2 = 0;
        for (int i = 0; i < someArr5.length; i++) {
            for (int k = 0; k < someArr5[i].length; k++) {
                randVal1 = (int) (Math.random() * 99 + 1);
                randVal2 = (int) (Math.random() * 99 + 1)*(-1);
                someArr5[i][k] = randVal1+randVal2;
                if (someArr5[i][k] > maxVal) {maxVal = someArr5[i][k];}
            }
        }
        System.out.println(Arrays.deepToString(someArr5));
        System.out.println(maxVal);
    }
}
