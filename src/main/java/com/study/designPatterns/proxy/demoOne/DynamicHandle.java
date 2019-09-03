package main.java.com.study.designPatterns.proxy.demoOne;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: whb
 * @date: 2019/9/3 22:11
 * @description: 动态代理处理器
 */
public class DynamicHandle implements InvocationHandler {

    private Object object;

    public DynamicHandle(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(object, args);
        return returnValue;
    }
}
