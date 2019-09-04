package main.java.com.study.designPatterns.proxy.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * @author: whb
 * @date: 2019/9/4 9:54
 * @description: 测试JDK动态代理
 */
public class TestJdkProxy {
    public static void main(String[] args) {
        //新建目标对象
        Object target = new UserDaoImpl();

        //创建事务处理器
        TransactionHandler handler = new TransactionHandler(target);

        //生成代理类并使用接口对其进行引用
        UserDao userDao = (UserDao) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
        //针对接口进行方法调用
        userDao.save();

    }

}
