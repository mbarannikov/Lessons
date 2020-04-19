package ru.ifmo.base.lesson12;

import java.io.IOException;

public class ExceptionLesson {
    public static void main(String[] args){
//       исключени и ошибки - это объекты
        int a = 12;
        int b = 0;
        int res;
//        res = a / b; RuntimeException - ArithmeticException
        int[] arr =  new int[3];
//        arr[89] = 12; ArrayIndexOutOfBoundsException
        String string = null;
//        string.equals("hello"); NullPointerException
        Object someData = "253";  // доступны методы Object
        Integer someInteger;
//        someInteger = (Integer) someData; // ClassCastException
//        обработка unchecked exception
        try{
            System.out.println("before a / b");
            res = a / b;
            System.out.println("after a / b");
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            res = 1000;
        }
        System.out.println("after try catch");
        System.out.println("res = "+ res);

        try{
            if(System.currentTimeMillis() % 2 == 0) someInteger = (Integer) someData;
            else arr[77] = 100;
        }catch (ClassCastException e){ //перехватывает ClassCastException и всех его потомков
            System.out.println("Problem with type cast");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Problem with array");
        }

        try{
            if(System.currentTimeMillis() % 2 == 0) someInteger = (Integer) someData;
            else arr[77] = 100;
        }catch (ClassCastException | ArrayIndexOutOfBoundsException e){
            System.out.println("Problem with cast or array");
            System.out.println(e.getMessage());
        }catch (RuntimeException e){
            System.out.println("Problem with RuntimeException");
            System.out.println(e.getMessage());
        }

        try{
            arr[88] = 100;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Problem with array");
        }
        finally {
//            выполнится в случае любого исключения, даже которое не перехватил catch
            System.out.println("finally");
        }
//
//        voidWithUncheckedException(40);
//        voidWithUncheckedException(10);

//        try {
////            метод генерирует обрабатываемое исключение,
////            поэтому мы обязаны обрабатывать его в блоке try-catch
////            или пробросить на уровень выше
//            voidWithCheckedException("asd.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        SomeMessage someMessage = null;
        try{
            someMessage = new SomeMessage("на", "текст");
        }catch (ChatException e){
            try{
                throw new ChatException("some data").initCause(e);
            }catch (Throwable ex){
                System.out.println("Throwable"+ex.getCause());
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
      //  System.out.println(someMessage.getText());

    }
    private static void  voidWithCheckedException(String s) throws IOException{
        if (s.endsWith("txt")){
            new IOException("Проблема с файлом");
        }
        System.out.println("s = "+ s);
    }

    private static void voidWithUncheckedException(int a){
        if(a < 15){
           throw new IllegalArgumentException("значение не должно быть меньше 15");
        }
        System.out.println("a = " + a);
    }
}
