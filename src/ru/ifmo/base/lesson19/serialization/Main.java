package ru.ifmo.base.lesson19.serialization;

import java.io.*;

public class Main  {
    public static void main(String[] args) {

        Pupil pupil1 = new Pupil();
        pupil1.setAge(7);
        pupil1.setName("pupil1");
        pupil1.setGroup(new Group("Химия", 12));
        pupil1.learn();

        Pupil pupil2 = new Pupil();
        pupil2.setAge(8);
        pupil2.setName("pupil2");
        pupil2.setGroup(new Group("Биология", 22));
        pupil2.learn();

        Director director = new Director("Super Speech");
        director.setAge(44);
        director.setName("director");
        director.setRating(2);

        File file = new File("school.bin");
        System.out.println("ДО ЗАПИСИ " + pupil1);
        System.out.println("ДО ЗАПИСИ " + pupil2);
        System.out.println("ДО ЗАПИСИ " + director);

        objectToFile(file, pupil1);

        Pupil pupilFromFile1 = (Pupil) getObjectFromFile(file);
        System.out.println("ПОСЛЕ ЧТЕНИЯ " + pupilFromFile1);
        System.out.println(pupil1.equals(pupilFromFile1));

        objectToFile(file, pupil2);

        Pupil pupilFromFile2 = (Pupil) getObjectFromFile(file);
        System.out.println("ПОСЛЕ ЧТЕНИЯ " + pupilFromFile2);
        System.out.println(pupil2.equals(pupilFromFile2));

        objectToFile(file, director);
        Director directorFromFile = (Director) getObjectFromFile(file);
        System.out.println("ПОСЛЕ ЧТЕНИЯ " + directorFromFile);
        System.out.println(director.equals(directorFromFile));
    }

    private  static void objectToFile(File file, Object obj){
// FileOutputStream    запись файла
        try (FileOutputStream fileOutput = new FileOutputStream(file);
// ObjectOutputStream -- сериализация объекта
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)){
// app --> objectOutput --> OutputStream
            objectOutput.writeObject(obj);
        } catch (FileNotFoundException ignored) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Object getObjectFromFile(File file){
        Object obj = null;
//  FileInputStream чтение файла
        try(FileInputStream fileInput = new FileInputStream(file);
//    ObjectInputStream - десериализация
            ObjectInputStream objectInput = new ObjectInputStream(fileInput)
            ) {
//           InputStream(file) --> objectInput --> app
            obj = objectInput.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл file не найден");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Проблема в момент чтения");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("readObject - Класс не найден");
        }
        return obj;
    }

}
