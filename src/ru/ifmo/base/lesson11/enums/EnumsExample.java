package ru.ifmo.base.lesson11.enums;

import java.util.Arrays;

public class EnumsExample {
    public static void main(String[] args) {
        Article article = new Article("Путешествие по Австралии");
        Article ukArticle = new Article("Путешествие по Великобритании");
        article.setText("Текст статьи");
        ukArticle.setText("Текст статьи");
        article.setCountry(Country.AUSTRALIA);
        ukArticle.setCountry(Country.UK);
        System.out.println(article.toString());
        System.out.println(ukArticle.toString());
//      enum methods
        Country[] countries = Country.values();
        System.out.println(Arrays.toString(countries));
        System.out.println(Country.UK.ordinal());
        for (Country country: countries
             ) {
            System.out.println("country:" + country.name() + " - " + country.ordinal());
        }
        System.out.println(Country.valueOf("USA"));
        int codeHigh = Priority.HIGH.getCode();
        System.out.println("codeHigh = " + codeHigh);
        Priority low = Priority.LOW;
        Priority low2 = Priority.LOW;
        low.setCode(123);
        System.out.println(low2.getCode());
        Operation operation = Operation.MULTI;
        System.out.println(operation.action(2,6));
        operation = Operation.SUM;
        System.out.println(operation.action(2,6));
        
 Planet[] planets = Planet.values();
        for (Planet p: planets
             ) {
            System.out.println(p.name()+"-"+p.getName()+"-"+p.getMassa() +"-"+p.getMassa());
        }
        
        
    }
}
// enum - перечисление связанных констант
enum Country{
    UK, USA, AUSTRALIA // элементы enum
}
enum  Priority{
    HIGH(10), MIDDLE(5), LOW(1);
    private int code;

    Priority(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

enum Operation{
    SUM{
        @Override
        public int action(int a, int b) {
            return a + b;
        }
    },
    MULTI{
        @Override
        public int action(int a, int b) {
            return a * b;
        }
    };
    public abstract int action(int a, int b);
}

enum  Planet {
    VENERA("Венера", 1,10), EARTH("Earth", 3,30), MARS("Mars",2,20), UPITER("Upiter",10, 100);
    private String name;
    private int massa;
    private int radius;

    Planet(String name, int massa, int radius) {
        this.name = name;
        this.massa = massa;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public int getMassa() {
        return massa;
    }

    public int getRadius() {
        return radius;
    }
}