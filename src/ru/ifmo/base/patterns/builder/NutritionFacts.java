package ru.ifmo.base.patterns.builder;

public class NutritionFacts {
    // обязательные параметры
    private final int servings;
    // необязательные параметры, инициализируются значениями по умолчанию
    private final int calories;
    private final int fat;

    public static class Builder{
        // обязательные параметры
        private final int servings;
        // необязательные параметры
        private int calories = 1;
        private int fat = 2;
// конструктор для обязательных
        public Builder(int servings) {
            this.servings = servings;
        }
        //    сеттеры для остальных
        public Builder calories(int caloriesVal) {
            calories = caloriesVal; //изменение объекта
            return this; // возвращает ссылку на измененый объект
        }

        public Builder fat(int fatVal) {
            fat = fatVal;  //изменение объекта
            return this; // возвращает ссылку на измененый объект
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    public NutritionFacts(Builder builder) {
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }
}
