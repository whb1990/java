package main.java.com.study.designPatterns.proxy.cglibProxy;

/**
 * @author: whb
 * @date: 2019/9/4 11:20
 * @description: Cglib动态代理测试
 */
public class TestCglibProxy {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        CglibProxy cglibProxy = new CglibProxy();
        UserDaoImpl userDaoCglibProxy = (UserDaoImpl) cglibProxy.getInstance(userDao);
        userDaoCglibProxy.save();
    }
}
