package org.proxy.common;

import org.springframework.context.annotation.Bean;

public class ConfigApp {


    @Bean
    public DogClass getDogClassBean() {
        return new DogClass();
    }

}
