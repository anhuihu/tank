package com.factoryMethod;

public class CarFactory {
    public Car create() {
        System.out.println("the car created");
        return new Car();
    }
}
