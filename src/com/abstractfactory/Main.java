package com.abstractfactory;


public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.go();
        AK47 w = new AK47();
        w.shoot();
        Bread b = new Bread();
        b.printName();


    }

}
