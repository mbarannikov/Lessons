package ru.ifmo.base.lesson15;

import java.lang.ref.WeakReference;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User cbf = new User("cbf", "12443", Role.USER);
        User asd = new User("asd", "2625", Role.ADMIN);
        User rty = new User("rty", "8734", Role.USER);
        User bnm = new User("bnm", "2688", Role.ADMIN);
        System.out.println("---HashMap---");
//        1. хранит ключи в hash table (используется hashCode ключа)
//        2. для объектов, которые используется в качестве ключей должны быть
//        переопределены методы equals and hashCode
//        3. порядок хранения элементов может отличаться от порядка добавления
//        4. null может быть испольован в качестве ключа
        HashMap<String, User> userHashMap = new HashMap<>();
//        в качестве ключей логины, в качестве значений пользователи
        userHashMap.put(asd.getLogin(), asd);
        userHashMap.put(cbf.getLogin(), cbf);
        userHashMap.put(rty.getLogin(), rty);
        userHashMap.put(bnm.getLogin(), bnm);
        userHashMap.put(null, null);
        System.out.println(userHashMap);
        System.out.println(userHashMap.get(111));
        System.out.println(userHashMap.getOrDefault("ggg",rty));
        System.out.println(userHashMap.remove("cbf"));
        System.out.println(userHashMap.remove("bnm",bnm));
        System.out.println(userHashMap.replace(null, asd));
        System.out.println(userHashMap.replace(null, asd,null));
//        userHashMap.clear();
//        userHashMap.containsKey();
//        userHashMap.containsValue();
//        userHashMap.entrySet();
//        userHashMap.get();
//        userHashMap.getOrDefault()
//        userHashMap.isEmpty();
//        userHashMap.keySet();
//        userHashMap.put();
//        userHashMap.putAll();
//        userHashMap.putIfAbsent();
//        userHashMap.remove();   //2
//        userHashMap.replace(); //2
//        userHashMap.size();
//        userHashMap.values();
        System.out.println("---Перебор элементов map---");
        for (Map.Entry<String,User> entry: userHashMap.entrySet()
             ) {
            System.out.println(entry.getKey() + " : " + entry.getValue());

        }

        System.out.println("---EnumMap---");
//        1. использует enum в качестве ключей, все ключи должны быть одного типа
//        (все они должны быть элементами одного enum)
//        2. null нельзя использовать в качестве ключа
//        3. значения хранятся в массиве, размер массива - количество элементов в enum
//        4. порядок хранения элементов соответсвует порядку элементов в enum
//        5. для извлечения значений используется порядковый номер ключа vals[key.ordinal()]
        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);
        enumMap.put(Role.USER, new ArrayList<>(Arrays.asList(cbf, rty)));
        enumMap.put(Role.USER, new ArrayList<>(Arrays.asList(cbf, rty)));
//        List<User> userList = Arrays.asList(cbf,rty);
//        ArrayList<User> userArrayList = new ArrayList<>(userList);
//        enumMap.put(Role.USER, userArrayList);
        enumMap.put(Role.ADMIN, new ArrayList<>(Arrays.asList(asd,bnm)));
        System.out.println(enumMap);
        System.out.println(enumMap.get(Role.USER));
        System.out.println(enumMap.get(Role.ADMIN));
        System.out.println(Role.class);
        System.out.println("---Перебор элементов map---");
        for (Map.Entry<Role,ArrayList<User>> entry: enumMap.entrySet()
        ) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//            System.out.println(entry.getValue().get());

        }
        ArrayList<User> users = enumMap.get(Role.ADMIN);
        for (User u : users
             ) {
            System.out.println(u.getLogin());
        }
        User newUser = new User("newUser","676",Role.ADMIN);
        System.out.println("---Добавление newUser---");
//        enumMap.put(newUser.getRole(),new ArrayList<>(Arrays.asList(newUser)));
        System.out.println(enumMap.get(newUser.getRole()));
        enumMap.get(newUser.getRole()).add(newUser);
        System.out.println(enumMap.get(Role.ADMIN));
        System.out.println("---TreeMap---");
//        1. хранит элементы в отсортированнм по ключам порядке
//        2. null не может быть использован в качестве ключа
//        3. класс, объекты которого используется в качестве ключей
//        должен имплементировать интерфейс Comparable,
//        либо объект Comparator должен передаваться в конструктор TreeMap
//        4. основан на алгоритме красно-черного дерева
//
        userHashMap.remove(null);
        TreeMap<String, User> treeMap = new TreeMap<>(userHashMap);
        System.out.println(treeMap);
        treeMap.put(asd.getLogin(),asd);
        treeMap.put(rty.getLogin(),rty);
        treeMap.put(bnm.getLogin(),bnm);
        System.out.println(treeMap);
        System.out.println("---WeakHashMap---");
//        1-4. правила HashMap
//        5. запись будет удалена при сборке мусора,
//        если на ключи не осталось сильных ссылок
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        Object weakKey = new Object();
        String weakVal = "String value";
        weakHashMap.put(weakKey,weakVal);
        System.out.println(weakHashMap);
        HashMap<Object, String> hashMap = new HashMap<>();
        Object hashKey = new Object();
        String hashVal = "String value";
        hashMap.put(hashKey,hashVal);
        System.out.println(hashMap);
        weakKey = null;
        hashKey = null;
        System.gc();
        System.out.println(weakHashMap);
        System.out.println(hashMap);
        WeakReference<User> weakUser = new WeakReference<>(newUser);
        newUser = null;
        System.out.println(newUser);
        System.out.println("weakUser before gc " + weakUser);
        System.gc();
        System.out.println("weakUser after gc " + weakUser);
    }
}
