package com.Singleton;

public class Cat implements Comparable {
    int weight, height;
    @Override
    public int compareTo(Object o) {
        Cat c = (Cat) o;
        if (this.weight<c.weight) return -1;
        if (this.height<c.height) return -1;
        else return 0;

    }


    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

}
