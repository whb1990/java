package main.java.com.study.designPatterns.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: whb
 * @date: 2019/9/4 9:52
 * @description: 代理对象
 */
public class TransactionHandler implements InvocationHandler {
    /**
     * 需要代理的目标对象，这里设计为可以为任意对象添加事务控制, 所以将目标对象声明为Object
     */
    private Object target;

    /**
     * 构造TransactionHandler时传入目标对象
     *
     * @param target
     */
    public TransactionHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用目标方法前的处理
        System.out.println("开启事务控制...");
        //调用目标对象的方法
        Object result = method.invoke(target, args);
        //调用目标方法后的处理
        System.out.println("关闭事务控制...");
        //放回方法调用结果
        return result;
    }
}