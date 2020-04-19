package Tasks.Exception;
//Метод *static void throwException(Status status) throws JarException, FileNotFoundException, AccessDeniedException*
//        принимает на вход enum и выбрасывает следующие исключения в зависимости от значения status:
//        1. если status FILE_NOT_FOUND, выбрасывает FileNotFoundException
//        2. если status ACCESS_DENIED, выбрасывает AccessDeniedException
//        3. если status JAR_ERROR, выбрасывает JarException.
//
//        При вызове метода throwException обработать исключения следующим образом:
//        *FileNotFoundException* - выводить в консоль сообщение исключения(метод getMessage()) + любое дополнительное сообщение,
//        *AccessDeniedException* - выводить в консоль сообщение исключения (метод getMessage()) и снова выбрасывать exception,
//        *JarException* - выводить в консоль стек трейс.

//try {
//        int[] arr = new int[5];
//        arr[7] = 12;
//        } catch (Exception e) {
//        exceptionsList.add(e);
//        }

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Task1 {
    public static void main(String[] args) {

        try {
         //   throwException(Status.FILE_NOT_FOUND);
         //   throwException(Status.ACCESS_DENIED);
            throwException(Status.JAR_ERROR);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + ", задайте другое имя ");
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
            try {
                throw new AccessDeniedException("новое исключение");
            } catch (AccessDeniedException ex) {
                ex.printStackTrace();
            }
        } catch (JarException e) {
            e.printStackTrace();
        }
    }


    public static void throwException(Status status) throws JarException, AccessDeniedException, FileNotFoundException {
        if ("FILE_NOT_FOUND".equals(status.name())) {
            System.out.println("FILE_NOT_FOUND");
            throw new FileNotFoundException(status.getMsg());
        } else if ("ACCESS_DENIED".equals(status.name())) {
            System.out.println("ACCESS_DENIED");
            throw new AccessDeniedException(status.getMsg());
        } else if ("JAR_ERROR".equals(status.name())) {
            System.out.println("JAR_ERROR");
            throw new JarException(status.getMsg());
        }
    }
}


enum Status {
    FILE_NOT_FOUND("Файл не найден"), ACCESS_DENIED("Доступ запрещен"), JAR_ERROR("Ошибка Jar");
    private String msg;

    Status(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}