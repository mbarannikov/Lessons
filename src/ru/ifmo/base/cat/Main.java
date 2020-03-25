package ru.ifmo.base.cat;

public class Main {
    public static void main(String[] args) {
        Cat myCat = new Cat(120, "Downing street", 12);
        Cat otherCat = new Cat(150,"King street",25);
        myCat.fightCat(otherCat);
        System.out.println(myCat.getHp());
        otherCat.fightCat(myCat);
        System.out.println(otherCat.getHp());
        while (myCat.getHp()>0 && otherCat.getHp()>0){
            myCat.fightCat(otherCat);
            otherCat.fightCat(myCat);
        }
        System.out.println(myCat.getHp());
        System.out.println(otherCat.getHp());
        if (myCat.getHp()>0){
            System.out.println("myCat win");
        }else {
            System.out.println("otherCat win");
        }
        myCat.setName(null);
    }
}
