package main.java.com.study.designPatterns.proxy.jdkProxy;

/**
 * @author: whb
 * @date: 2019/9/4 9:51
 * @description: 目标对象
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("保存用户信息...");
    }
}
