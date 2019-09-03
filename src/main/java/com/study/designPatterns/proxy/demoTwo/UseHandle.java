package main.java.com.study.designPatterns.proxy.demoTwo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: whb
 * @date: 2019/9/3 22:52
 * @description: 将InvocationHandler这个接口单独拿出来写
 */
public class UseHandle implements InvocationHandler {
    private Object object;

    public UseHandle(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(object, args);
        return returnValue;
    }
}
