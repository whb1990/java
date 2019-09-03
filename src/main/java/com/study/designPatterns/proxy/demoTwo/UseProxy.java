package main.java.com.study.designPatterns.proxy.demoTwo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: whb
 * @date: 2019/9/3 22:26
 * @description: 动态代理类
 */
public class UseProxy {

    /**
     * 维护一个目标对象
     */
    private Object object;

    public UseProxy(Object object) {
        this.object = object;
    }

    /**
     * 给目标对象生成代理对象
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("--------开始动态代理--------" + "\n");
                        //执行目标对象方法
                        Object returnValue = method.invoke(object, args);
                        System.out.println("--------结束动态代理--------");
                        return returnValue;
                    }
                });
    }
}
