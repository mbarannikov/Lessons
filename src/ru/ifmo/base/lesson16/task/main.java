package ru.ifmo.base.lesson16.task;

import ru.ifmo.base.lesson15.Role;
import ru.ifmo.base.lesson15.User;
import ru.ifmo.base.lesson16.annotations.ClassConfig;
import ru.ifmo.base.lesson16.annotations.Required;
import ru.ifmo.base.lesson16.reflection.TextMessage;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        MyReflection myReflection = new MyReflection("Вася", 37, new int[]{123, 345, 456});
        Class myReflClass = MyReflection.class;
        Annotation[] annotations = myReflClass.getAnnotations();
        System.out.println(annotations);
        if (myReflClass.isAnnotationPresent(MyClassConfig.class)) {
            System.out.println("MyClassConfig");
//            ClassConfig classConfig = (ClassConfig) testClass.getDeclaredAnnotation(ClassConfig.class);
//            System.out.println(classConfig.prefix());
//            System.out.println(classConfig.version());
            Constructor<MyReflection> constructor = myReflClass.getDeclaredConstructor(String.class, int.class, int[].class);
            MyReflection reflectionMy = constructor.newInstance("Петя", 66, new int[]{333, 444, 555});
            toString(reflectionMy);
            Field[] fields = myReflClass.getDeclaredFields();
            for (Field field : fields
            ) {
                if (field.isAnnotationPresent(MyRequired.class)) {
                    Method method = myReflClass.getDeclaredMethod("setName", String.class);
                    method.setAccessible(true);
                    method.invoke(reflectionMy, "Петр");
//                    field.setAccessible(true);
//                    System.out.println(field.get(reflectionMy));
//                    System.out.println(field.getName());
                }
            }
            Method method = myReflClass.getDeclaredMethod("toString");
            method.setAccessible(true);
            System.out.println(method.invoke(reflectionMy));
        }

    }

    public static void toString(Object o) throws IllegalAccessException {
        Class oClass = o.getClass();
//        System.out.println(int.class.getComponentType());
        Field[] declaredFields = oClass.getDeclaredFields();
        //System.out.println(Arrays.toString(fields));
//        System.out.println(Arrays.toString(declaredFields));
        Method[] methods = oClass.getDeclaredMethods();
//        System.out.println(Arrays.toString(methods));

        for (Field field : declaredFields
        ) {

            field.setAccessible(true);
            Object fieldObj = field.get(o);
//            System.out.println(field.getType());
            if (field.getType().isArray()) {
                System.out.print(field.getName() + "[] : {");
                for (int i = 0; i < Array.getLength(fieldObj); i++) {
                    System.out.print(Array.get(fieldObj, i) + ", ");
                }
                System.out.println("}");
            } else if (fieldObj.getClass() == User.class) {
                toString(fieldObj);
            } else {
                System.out.println(field.getName() + " : " + fieldObj.toString());
            }

        }

    }
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

@MyClassConfig(prefix = "testMyReflection", version = 2)
class MyReflection {
    @MyRequired
    private String name;
    private int age;
    int[] data;
    User user;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyReflection{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", data=" + Arrays.toString(data) +
                ", user=" + user +
                '}';
    }

    public MyReflection(String name, int age, int[] data) {
        this.name = name;
        this.age = age;
        this.data = data;
        this.user = new User("qwe", "asd", Role.ADMIN);
    }
}
