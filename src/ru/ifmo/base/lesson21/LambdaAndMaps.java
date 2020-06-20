package ru.ifmo.base.lesson21;

import java.util.HashMap;
import java.util.function.BiConsumer;


public class LambdaAndMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Сидней", 3000);
        map.put("Париж", 5000);
        map.put("Лондон", 3700);

        System.out.println("---map foreach---");
        //BiConsumer<T, U> : void accept(T t, U u);
        BiConsumer<String, Integer> biConsumer = (key, value) ->
                System.out.println(key + " :: " + value);
        map.forEach(biConsumer);
//        map.computeIfPresent();
//        map.computeIfAbsent();
//        map.merge();


    }
}
