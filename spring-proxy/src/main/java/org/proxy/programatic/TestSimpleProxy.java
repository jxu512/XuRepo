package org.proxy.programatic;

import org.proxy.common.Animal;
import org.proxy.common.Dog;
import org.proxy.common.DogAdvise;
import org.springframework.aop.framework.ProxyFactory;

public class TestSimpleProxy {
    public static void main(String[] args) {

        ProxyFactory factory = new ProxyFactory(new Dog());
        factory.addInterface(Animal.class);
        factory.addAdvice(new DogAdvise());

        Animal dog = (Animal) factory.getProxy();
        dog.sound();
        dog.move();
    }
}