package main.java.com.study.designPatterns.proxy.cglibProxy;

/**
 * @author: whb
 * @date: 2019/9/4 11:24
 * @description: 目标对象实现类
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("保存用户信息...");
    }
}
