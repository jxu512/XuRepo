package org.proxy.common;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class DogAdvise implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print(invocation.getMethod().getName() + " is: ");
        return invocation.proceed();
    }
}
