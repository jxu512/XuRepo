package org.proxy.cglib;

import org.proxy.common.Animal;
import org.proxy.common.Dog;
import org.proxy.common.DogClass;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProxyFactoryBean {

    @Autowired
    private DogClass dogClass;

    @Bean
    @Autowired
    public ProxyFactoryBean getProxyFactoryBean() throws ClassNotFoundException {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(dogClass);
        proxyFactoryBean.setInterceptorNames(new String[] {"dogAdvise"});

        return proxyFactoryBean;
    }
}
