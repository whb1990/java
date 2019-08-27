package main.java.com.study.lock.reentrantReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: whb
 * @date: 2019/8/27 16:27
 * @description: 读写锁测试--银行存取款
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        // 创建账户
        MyCount myCount = new MyCount("58000993245232131", 10000);
        // 创建用户，并指定账户
        User user = new User("Tommy", myCount);

        // 分别启动3个“读取账户金钱”的线程 和 3个“设置账户金钱”的线程
        for (int i = 0; i < 3; i++) {
            user.getCash();
            user.setCash((i + 1) * 1000);
        }
    }
}

class User {
    /**
     * 用户名
     */
    private String name;
    /**
     * 所要操作的账户
     */
    private MyCount myCount;
    /**
     * 执行操作所需的锁对象
     */
    private ReadWriteLock myLock;

    User(String name, MyCount myCount) {
        this.name = name;
        this.myCount = myCount;
        this.myLock = new ReentrantReadWriteLock();
    }

    public void getCash() {
        new Thread(() -> {
            myLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " getCash start");
                myCount.getCash();
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName() + " getCash end");
            } catch (InterruptedException e) {
            } finally {
                myLock.readLock().unlock();
            }
        }).start();
    }

    public void setCash(final int cash) {
        new Thread(() -> {
            myLock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " setCash start");
                myCount.setCash(cash);
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName() + " setCash end");
            } catch (InterruptedException e) {
            } finally {
                myLock.writeLock().unlock();
            }
        }).start();
    }
}

class MyCount {
    /**
     * 帐号
     */
    private String id;
    /**
     * 账户余额
     */
    private int cash;

    MyCount(String id, int cash) {
        this.id = id;
        this.cash = cash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCash() {
        System.out.println(Thread.currentThread().getName() + " getCash cash=" + cash);
        return cash;
    }

    public void setCash(int cash) {
        System.out.println(Thread.currentThread().getName() + " setCash cash=" + cash);
        this.cash = cash;
    }
}
