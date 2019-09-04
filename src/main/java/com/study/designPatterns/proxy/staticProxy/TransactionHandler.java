package main.java.com.study.designPatterns.proxy.staticProxy;

/**
 * @author: whb
 * @date: 2019/9/4 9:46
 * @description: 代理对象
 */
public class TransactionHandler implements UserDao {

    /**
     * 目标代理对象
     */
    private UserDaoImpl target;

    /**
     * 构造代理对象时传入目标对象
     *
     * @param target
     */
    public TransactionHandler(UserDaoImpl target) {
        this.target = target;
    }

    @Override
    public void save() {
        //调用目标方法前的处理
        System.out.println("开启事务控制...");
        //调用目标对象的方法
        target.save();
        //调用目标方法后的处理
        System.out.println("关闭事务控制...");
    }

}
