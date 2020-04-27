package ru.ifmo.base.lesson13;

public class GenericExample {
    public static void main(String[] args) {

        User<String> stringUser = new User<>();
        stringUser.setId("fkdsf9878fdjsk");
        stringUser.setLogin("qwe");
        stringUser.setPwd("123");
//        в generic нельзя использовать примитивы (только классы обертки)
        User<Integer> integerUser = new User<>();
        integerUser.setId(14);
        integerUser.setLogin("fgh");
        integerUser.setPwd("111");

        System.out.println(stringUser);
        System.out.println(integerUser);

        PairContainer<String, Integer> container1 = new PairContainer<>("qwe",12);
        PairContainer<Double, User> container2 = new PairContainer<>(3.3,stringUser);
        System.out.println(container1);
//        user id не определен и он станет типом Object
        container2.getValue().setId(12);
        container2.getValue().setId("abc");
        System.out.println(container2.getValue().getId());
        PairContainer<Double, User<String>> container3 = new PairContainer<>(3.3,stringUser);
        container3.getValue().setId("klj78797");
        User<Number> numberUser = new User<>();
        numberUser.setId(44.5667);
        PairContainer<String, User<Number>> container4 = new PairContainer<>("hello", numberUser);
        System.out.println(container4.getValue().getId().intValue());
    }
}
