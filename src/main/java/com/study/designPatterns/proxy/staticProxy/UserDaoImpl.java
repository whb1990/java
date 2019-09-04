package main.java.com.study.designPatterns.proxy.staticProxy;

/**
 * @author: whb
 * @date: 2019/9/4 9:46
 * @description: 目标对象
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("正在保存用户...");
    }
}
