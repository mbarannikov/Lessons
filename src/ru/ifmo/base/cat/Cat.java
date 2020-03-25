package ru.ifmo.base.cat;

public class Cat {
    String name;
    int weight;
    int age;
    String color;
    String ownerAddress;
    int hp;
    int power;

    public Cat(String name, String color) {
        setName(name);
        setColor(color);
    }

    public Cat(int hp, String ownerAddress, int power) {
        setHp(hp);
        setOwnerAddress(ownerAddress);
        setPower(power);
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public int getHp() {
        return hp;
    }

    public int getPower() {
        return power;
    }

    public void setName(String name) {
        if(name != null&&name.length()>3) {
            this.name = name;
        }
    }

    public void setWeight(int weight) {
        if(weight>0) {
            this.weight = weight;
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void printInfo() {
        System.out.println("Имя кота:"+ name);
    }

    public void fightCat(Cat anotherCat){

            hp = hp - anotherCat.getPower();

    }

}
