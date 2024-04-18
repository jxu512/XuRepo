package org.proxy.common;

public class Robin implements Animal{

    @Override
    public void move() {
        System.out.println("fly");
    }

    @Override
    public void sound() {
        System.out.println("chirp");
    }
}
