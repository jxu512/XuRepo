package org.proxy.common;

public class Dog implements Animal{

    @Override
    public void move() {
        System.out.println("run");
    }

    @Override
    public void sound() {
        System.out.println("bark");
    }
}
