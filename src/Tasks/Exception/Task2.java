package Tasks.Exception;

//2. Создать список исключений и заполнить его 9 различными runtime исключениями.
//        Например,
//  try {
//        int[] arr = new int[5];
//        arr[7] = 12;
//        } catch (Exception e) {
//        exceptionsList.add(e);
//        }

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Task2 {
    private static Exception[] exceptions = new Exception[9];
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[7] = 12;
        } catch (Exception e) {
            addException(e);
        }
        try {
            Object x[] = new String[3];
            x[0] = 0;
        } catch (Exception e) {
            addException(e);
        }
        try {
            int a = 1;
            int b = 0;
            a /= b;
        } catch (Exception e) {
            addException(e);
        }
        try {
            Object a = "a";
            Integer b = (Integer) a;
        } catch (Exception e) {
            addException(e);
        }
        try {
            String s = null;
            s.equals("null");
        } catch (Exception e) {
            addException(e);
        }
        try {
            throw new IllegalStateException();
        } catch (Exception e) {
            addException(e);
        }
        try {
            throw new SecurityException();
        } catch (Exception e) {
            addException(e);
        }
        try {
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            addException(e);
        }
        try {
            EnumConstantException.valueOf("THREE");
        } catch (Exception e) {
            addException(e);
        }
        printException();
    }

    public static void addException(Exception ex){
        for (int i = 0; i < exceptions.length; i++) {
            if (exceptions[i] == null) {exceptions[i] = ex; break;}
        }
    }

    public static void printException(){
        for (Exception e: exceptions) {
            if (e != null)System.out.println(e);
        }
    }
}

enum EnumConstantException{
    ODIN, DWA
}


