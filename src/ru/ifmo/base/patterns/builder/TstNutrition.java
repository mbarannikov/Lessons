package ru.ifmo.base.patterns.builder;

public class TstNutrition {
    public static void main(String[] args) {
        NutritionFacts appleFacts =
                new NutritionFacts.Builder(3)
                .calories(200)
                .fat(4)
                .build();
        System.out.println(appleFacts);
    }
}
