package org.proxy.annotation;

import org.proxy.common.Dog;
import org.proxy.common.DogAdvise;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigApp {

    @Bean
    public Dog getDogBean() {
        return new Dog();
    }

    @Bean(name="dogAdvise")
    public DogAdvise getDogAdviseBean() {
        return new DogAdvise();
    }

}
