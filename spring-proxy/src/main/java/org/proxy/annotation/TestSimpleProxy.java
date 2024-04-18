package org.proxy.annotation;

import org.proxy.common.Animal;
import org.proxy.common.ConfigApp;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestSimpleProxy {

    @Autowired
    private ProxyFactoryBean proxyFactoryBean;

    public static void main(String[] args) {
        new TestSimpleProxy().testProxy();
    }

    private void testProxy() {
        try (AnnotationConfigApplicationContext appContext
                     = new AnnotationConfigApplicationContext(ConfigProxyFactoryBean.class, ConfigApp.class)) {
            proxyFactoryBean = appContext.getBean(ProxyFactoryBean.class);
        }
        Animal dog = (Animal) proxyFactoryBean.getObject();
        dog.sound();
        dog.move();
    }
}