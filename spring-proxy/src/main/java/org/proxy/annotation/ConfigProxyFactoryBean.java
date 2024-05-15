package org.proxy.annotation;

import org.proxy.common.Animal;
import org.proxy.common.Dog;
import org.proxy.common.DogAdvise;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProxyFactoryBean {

    @Autowired
    private Dog dog;

    @Bean
    public Dog getDogBean() {
        return new Dog();
    }

    @Bean(name="dogAdvise")
    public DogAdvise getDogAdviseBean() {
        return new DogAdvise();
    }
    @Bean
    public ProxyFactoryBean getProxyFactoryBean() throws ClassNotFoundException {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setProxyInterfaces(new Class[] {Animal.class});
        proxyFactoryBean.setTarget(dog);
        proxyFactoryBean.setInterceptorNames(new String[] {"dogAdvise"});

        return proxyFactoryBean;
    }
}
