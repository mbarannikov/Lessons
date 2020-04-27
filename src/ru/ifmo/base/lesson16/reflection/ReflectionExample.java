package ru.ifmo.base.lesson16.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionExample {
//    static {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
//    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class strClass = String.class;
        System.out.println(strClass);
        Class intClass = int.class;
        System.out.println(intClass);
        Class textMessageClass = TextMessage.class;
        System.out.println(textMessageClass);
        TextMessage textMessage = new TextMessage("Срочное сообщение");
        textMessage.setText("Рефлексия");
        textMessageClass = textMessage.getClass();
        String className = textMessageClass.getName();
        String packageName = textMessageClass.getPackage().getName();
        System.out.println(className);
        System.out.println(packageName);

        Class[] interfaces = textMessageClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces ));

        System.out.println(textMessageClass.getSuperclass().getSuperclass().getSuperclass());
        Class[] parentInterfaces = textMessageClass.getSuperclass().getInterfaces();
        System.out.println(Arrays.toString(parentInterfaces));
        Class<TextMessage> tmClass = TextMessage.class;
        Field[] fields = tmClass.getFields();
        Field[] declaredFields = tmClass.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        System.out.println(Arrays.toString(declaredFields));

        Method[] methods = tmClass.getMethods();
        Method[] declaredMethods = tmClass.getDeclaredMethods();
        System.out.println(Arrays.toString(methods));
        System.out.println(Arrays.toString(declaredMethods));

        Constructor[] constructors = tmClass.getConstructors();
        System.out.println(Arrays.toString(constructors));

        Constructor<TextMessage> tmConstructor = tmClass.getDeclaredConstructor(String.class);
        System.out.println(tmConstructor);
        TextMessage reflectMessage = tmConstructor.newInstance("Рефлексивный объект");
        System.out.println(reflectMessage);
        Field field = tmClass.getDeclaredField("text");
        field.setAccessible(true);
        System.out.println(field.get(reflectMessage));

        field.set(reflectMessage,"значение установлено");
        System.out.println(reflectMessage.getText());

        Method method = tmClass.getDeclaredMethod("printText", String.class, String.class);
        method.setAccessible(true);
        method.invoke(reflectMessage, "!!!", "###");
        System.out.println(field.get(reflectMessage));

        BigTextMessage btm = new BigTextMessage("Big Message");
        field.set(btm, "Big text");
        System.out.println("btm " + field.get(btm));

//        Class
//        Field
//        Method (parameters)
        System.out.println(field.getModifiers());
        System.out.println(Modifier.isPrivate(field.getModifiers()));

    }
}
