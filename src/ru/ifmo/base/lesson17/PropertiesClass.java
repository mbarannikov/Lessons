package ru.ifmo.base.lesson17;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesClass {
    public static void main(String[] args) {
//        удобно использовать для работы с property файлами
        Properties properties = new Properties();
        try (InputStream input = PropertiesClass.class
                .getClassLoader()
                .getResourceAsStream("example.properties")) {
            properties.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(properties);
        System.out.println(properties.getProperty("key"));
        System.out.println(properties.getProperty("age"));
        System.out.println(properties.getProperty("data", "default"));

        properties.setProperty("ip1","12.546.546.545");
        properties.put("ip2","12.546.546.545");
        System.out.println(properties.values());
        System.out.println(properties.toString());
        System.out.println(properties);
        PropertiesLoader loader1 = PropertiesLoader
                .getPropertiesLoader("example.properties");
        PropertiesLoader loader2 = PropertiesLoader
                .getPropertiesLoader("example.properties");

        System.out.println(loader1.getProperties());
        System.out.println(loader2.getProperties());

        //        Comparator comp = new SomeComp();
//        Object a = 12;
//        Object b = 122;
//        int res = comp.compare(a, b);
    }
}
