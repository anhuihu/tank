package com.factoryMethod;

public class SimpleVehicleFactory {

    // 简单工厂 扩展性并不好
    public Car createCar() {
        // before processing
        return new Car();
    }

    public Broom CreateBroom() {
        return new Broom();
    }

}
