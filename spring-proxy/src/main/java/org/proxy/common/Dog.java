package org.proxy.common;

import org.aopalliance.aop.Advice;

public class Dog implements Animal, Advice {

    @Override
    public void move() {
        System.out.println("run");
    }

    @Override
    public void sound() {
        System.out.println("bark");
    }
}
