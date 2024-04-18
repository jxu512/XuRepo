package org.proxy.common;

import org.proxy.common.Dog;
import org.proxy.common.DogAdvise;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigApp {

    @Bean
    public Dog getDogBean() {
        return new Dog();
    }

    @Bean
    public DogClass getDogClassBean() {
        return new DogClass();
    }

    @Bean(name="dogAdvise")
    public DogAdvise getDogAdviseBean() {
        return new DogAdvise();
    }

}
