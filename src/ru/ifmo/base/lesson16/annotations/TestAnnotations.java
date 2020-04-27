package ru.ifmo.base.lesson16.annotations;

import ru.ifmo.base.lesson16.reflection.TextMessage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@ClassConfig(prefix = "test", version = 2)
public class TestAnnotations {
    @Required
    private String stringData;

    private int intData;

    public String getStringData() {
        return stringData;
    }
    @Required
    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    @Override
    public String toString() {
        return "TestAnnotations{" +
                "stringData='" + stringData + '\'' +
                '}';
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class testClass = TestAnnotations.class;
        Annotation[] annotations = testClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));
        if(testClass.isAnnotationPresent(ClassConfig.class)){
            System.out.println("ClassConfig");
            ClassConfig classConfig = (ClassConfig) testClass.getDeclaredAnnotation(ClassConfig.class);
            System.out.println(classConfig.prefix());
            System.out.println(classConfig.version());
        }

        // 2. если класс аннотирован аннотацией ConfigClass,
        // создать объект данного класса (использовать рефлексию!)
        // если поле отмечено аннотацией @Required - установить значение
        // данного поля (значение любое!)
        // значение поля установить через сеттер!!!
        // stringData / setStringData
        // field.getName()
        // field.getType()
        // у созданного объекта вызвать метод public String toString(),
        // используя рефлексию

//        Field stringDatafield = testClass.getDeclaredField("stringData");
//        stringDatafield.setAccessible(true);
//        stringDatafield.set(testClass,"значение установлено");
//        System.out.println("Значение поля "+ stringDatafield.get(testClass));

        Field[] fields = testClass.getDeclaredFields();
        for (Field field: fields
             ) {
            System.out.println("field.getName = "+field.getName());
            Annotation[] fieldDeclaredAnnotations = field.getDeclaredAnnotations();
            System.out.println(Arrays.toString(fieldDeclaredAnnotations));
            if (field.isAnnotationPresent(Required.class)){
                System.out.println("поле с Required");
            }
        }

        Method[] methods = testClass.getDeclaredMethods();
        for (Method method: methods
        ) {
            System.out.println(method.getName());
            Annotation[] methodDeclaredAnnotations = method.getDeclaredAnnotations();
            if (method.isAnnotationPresent(Required.class)){
                System.out.println("метод с Required");
            }
        }
    }
    // ДЗ к понедельнику
    // выбрать наиболее важные (интересные) на Ваш взгляд! методы
    // Class
    // Field
    // Method
    // Modifier

    // 1. написать рефлексивный статический static toString(Object o)
    // вывести информацию по полям объекта, используя рефлексию:
    // название поля: значение поля
//        примитивы / строки
    //        age: 67
    //        login: qwe
//        User user
//        user : @hashCode
//        int[] data
//        data: @hashCode

    // 2. если класс аннотирован аннотацией ConfigClass,
    // создать объект данного класса (использовать рефлексию!)
    // если поле отмечено аннотацией @Required - установить значение
    // данного поля (значение любое!)
    // значение поля установить через сеттер!!!
    // stringData / setStringData
    // field.getName()
    // field.getType()
    // у созданного объекта вызвать метод public String toString(),
    // используя рефлексию

}
