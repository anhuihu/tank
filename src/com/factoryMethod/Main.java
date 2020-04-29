package com.factoryMethod;

public class Main {
    public static void main(String[] args) {
//        Car c = new Car();
//        c.go();
        Moveable m = new CarFactory().create();


//        Moveable m = new Plane();
        m.go();
    }

}
