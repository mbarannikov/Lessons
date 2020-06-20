package ru.ifmo.base.lesson18;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

public class IOLesson {
    public static void main(String[] args) {
//        io (byte and char)
//        nio шире
        File file1 = new File("sources/filepath1.txt");
        File file2 = new File("sources/filepath2.txt");
        File file3 = new File("sources/filepath3.txt");
        File file4 = new File("sources/filepath4.txt");
        File file5 = new File("sources/filepath5.txt");
        File file_shifr = new File("sources/filepath_shifr.txt");

        try {
            System.out.println(file1.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.isDirectory());
//        System.out.println(file.getPath());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.isFile());
//        System.out.println(file.canRead());
//        System.out.println(file.canWrite());
//        System.out.println(file.canExecute());
//        System.out.println(file.length());
//        OutputStream ресурс <--- java app
//        InputStream  ресурс ---> java app
        try {

            writeToFileShifr(file_shifr,"зашифрованная строка222");
            System.out.println("file_shifr = " + readFromFileShifr(file_shifr));
            writeToFile(file1, "hello", false);
            writeToFile(file2, "world", false);
            writeToFileWithBuffer(file1);
            writeToFileWithBuffer(file2);
            //   writeToFileWithBuffer(file);
            System.out.println("file1 = "+readFromFileToByteArray(file1));
            System.out.println("file2 = "+readFromFileToByteArray(file2));
            byte [] bytes = imgToByteArray(new File("sources/pic1.png"));
//            System.out.println(Arrays.toString(bytes));

//            byteArrayToImage(new File("sources/picture.png"),bytes);
//            System.out.println(readFromFileToByteArray(file1));
//            writeReadData(file1);
            String from2files = readFromSeveralFiles(file1,file2);
            writeToFile(file3,from2files,false);
            writeToSeveralFiles(readFromFileToByteArray(file3),file4,file5);
            System.out.println("file3 = "+readFromFileToByteArray(file3));
            System.out.println("file4 = "+readFromFileToByteArray(file4));
            System.out.println("file5 = "+readFromFileToByteArray(file5));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private static void writeToFile(File file, String data, boolean append) throws IOException {

//        data ---> file
//        append = true - запись в конец файла
//        append = false - запись в начало файла
//        try-with-resources - ресурсы закрываются автоматически
//        close() из интерфейса AutoCloseable
//
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, append)) {
            byte[] bytes = data.getBytes();
            fileOutputStream.write(bytes);
        }
    }

    private static void writeToFileShifr(File file, String data) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                EncodeOutputStream out = new EncodeOutputStream(fileOutputStream)) {
            byte[] bytes = data.getBytes();
            out.write(bytes);
        }
    }

    public static String readFromFileShifr(File file) throws IOException {
        String string = null;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             EncodeInputStream in = new EncodeInputStream(fileInputStream)) {
            byte[] buf = new byte[1024];
            int data;
            while ((data = fileInputStream.read(buf)) > 0) {
                in.read(buf, 0, data);
            }
            string = buf.toString();//Arrays.toString(buf); // new String(byteArrayOutputStream.toByteArray());
        }
        return string;
    }

    private static void writeToFileWithBuffer(File file) throws IOException {
//        file <---[buffer]<---- java app
//
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
            for (int i = 0; i < 11; i++) {
                bufferedOutputStream.write((i + " ").getBytes());
            }
        }
    }

    public static String readFromFileToByteArray(File file) throws IOException {
        String string = null;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buf = new byte[40];
            int data;
            while ((data = fileInputStream.read(buf)) > 0) {
                System.out.println("data = "+data);
                System.out.println("buf = "+Arrays.toString(buf));
                byteArrayOutputStream.write(buf, 0, data);
            }
            string = byteArrayOutputStream.toString(); // new String(byteArrayOutputStream.toByteArray());
        }
        return string;
    }

    public static byte[] imgToByteArray(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(image, "png", output);
        return output.toByteArray();
    }

    public static boolean byteArrayToImage(File file, byte[] bytes) throws IOException {
        try (ByteArrayInputStream input = new ByteArrayInputStream(bytes)) {
            BufferedImage image = ImageIO.read(input);
            return ImageIO.write(image, "png", file);
        }
    }

    private static String readFromSeveralFiles(File ... files) throws IOException {
        String string = null;
        try (
                FileInputStream i1 = new FileInputStream(files[0]);
                FileInputStream i2 = new FileInputStream(files[1]);
                ByteArrayOutputStream bout = new ByteArrayOutputStream();){
                SequenceInputStream stream = new SequenceInputStream(i1,i2);
                byte[] bytes = new byte[10];
                int data;
                while ((data = stream.read(bytes)) > 0){
                    bout.write(bytes,0, data);
                }
                string = bout.toString();
        }

               return string;
    }

    private static void writeToSeveralFiles(String data, File ... files) throws IOException {
        try (
                FileOutputStream o1 = new FileOutputStream(files[0]);
                FileOutputStream o2 = new FileOutputStream(files[1]);){
            byte[] bytes = data.getBytes();
            o1.write(bytes,0,bytes.length/2-1);
            o2.write(bytes,bytes.length/2, bytes.length/2);

        }
    }

//    outputstream - запись
//    inputstream - чтение
//        OutputStream ресурс <--- java app
//        InputStream  ресурс ---> java app
private static void writeReadData(File file) throws IOException {
    try (FileOutputStream fileOutput = new FileOutputStream(file);
         DataOutputStream dataOutput = new DataOutputStream(fileOutput)) {

        // задача DataOutputStream - преобразовать данные в байты,
        // вызвать метод write у объекта OutputStream и передать
        // в него этот набор байт
        // в данном случае метод write FileOutputStream
        dataOutput.writeBoolean(true);
        dataOutput.writeBoolean(false);
        dataOutput.writeDouble(6.555);
        dataOutput.writeInt(34);
        dataOutput.writeUTF("hello");
    }

    try (FileInputStream fileInput = new FileInputStream(file);
         DataInputStream dataInput = new DataInputStream(fileInput)) {

        System.out.println(dataInput.readBoolean());
        System.out.println(dataInput.readBoolean());
        System.out.println(dataInput.readDouble());
        System.out.println(dataInput.readInt());
        System.out.println(dataInput.readUTF());
    }

}

}

